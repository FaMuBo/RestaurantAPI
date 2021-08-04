package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entities.Branch;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.BranchRepository;
import com.exampleFinartz.demo.services.BranchService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {

    private static final Position InitStatus = Position.WAITING;
    private static final Position NewStatus = Position.APPROVED;


    @InjectMocks
    private BranchService branchService;

    @Mock
    private BranchRepository branchRepository;


    @Test
    public void whenFetchAll_thenReturnAllBranch() {
        Branch branch1 = Branch.builder().id(1l).name("Barış Döner Kartal").build();
        Branch branch2 = Branch.builder().id(2l).name("Barış Döner Avcılar").build();

        List<Branch> branchList = Arrays.asList(branch1, branch2);

        Mockito.when(branchRepository.findAll()).thenReturn(branchList);

        List<Branch> fetchedList = branchService.getAll();

        assertEquals(branchList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnBranch() {
        Branch branch = Branch.builder().name("Barış Döner Kartal").build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(branch);

        Branch fetchedBranch = branchService.getById(1L);

        assertEquals(branch.getId(), fetchedBranch.getId());
    }

    @Test
    public void whenAddBranch_thenReturnSavedBranch() {
        Branch branch = Branch.builder().name("Barış Döner Kartal").build();

        Mockito.doReturn(branch).when(branchRepository).save(branch);

        Branch returnedBranch = branchService.create(branch);

        assertEquals(branch.getName(), returnedBranch.getName());
    }

    @Test
    public void whenUpdateBranch_thenReturnUpdatedBranch() {
        Branch existBranch = Branch.builder().id(1L).position(InitStatus).build();
        Branch newBranch = Branch.builder().id(1L).position(NewStatus).build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(existBranch);
        Mockito.when(branchRepository.save(newBranch)).thenReturn(newBranch);

        Branch updatedBasket = branchService.update(newBranch);
        Assertions.assertEquals(existBranch.getPosition(), NewStatus);
        Assertions.assertNotEquals(existBranch.getPosition(), InitStatus);
    }
}
