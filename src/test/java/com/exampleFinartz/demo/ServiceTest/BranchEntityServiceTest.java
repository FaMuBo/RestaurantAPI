package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.enums.Position;
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
public class BranchEntityServiceTest {

    private static final Position InitStatus = Position.WAITING;
    private static final Position NewStatus = Position.APPROVED;


    @InjectMocks
    private BranchService branchService;

    @Mock
    private BranchRepository branchRepository;


    @Test
    public void whenFetchAll_thenReturnAllBranch() {
        BranchEntity branchEntity1 = BranchEntity.builder().id(1l).name("Barış Döner Kartal").build();
        BranchEntity branchEntity2 = BranchEntity.builder().id(2l).name("Barış Döner Avcılar").build();

        List<BranchEntity> branchEntityList = Arrays.asList(branchEntity1, branchEntity2);

        Mockito.when(branchRepository.findAll()).thenReturn(branchEntityList);

        List<BranchEntity> fetchedList = branchService.getAll();

        assertEquals(branchEntityList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnBranch() {
        BranchEntity branchEntity = BranchEntity.builder().name("Barış Döner Kartal").build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(branchEntity);

        BranchEntity fetchedBranchEntity = branchService.getById(1L);

        assertEquals(branchEntity.getId(), fetchedBranchEntity.getId());
    }

    @Test
    public void whenAddBranch_thenReturnSavedBranch() {
        BranchEntity branchEntity = BranchEntity.builder().name("Barış Döner Kartal").build();

        Mockito.doReturn(branchEntity).when(branchRepository).save(branchEntity);

        BranchEntity returnedBranchEntity = branchService.create(branchEntity);

        assertEquals(branchEntity.getName(), returnedBranchEntity.getName());
    }

    @Test
    public void whenUpdateBranch_thenReturnUpdatedBranch() {
        BranchEntity existBranchEntity = BranchEntity.builder().id(1L).position(InitStatus).build();
        BranchEntity newBranchEntity = BranchEntity.builder().id(1L).position(NewStatus).build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(existBranchEntity);
        Mockito.when(branchRepository.save(newBranchEntity)).thenReturn(newBranchEntity);

        BranchEntity updatedBasket = branchService.update(newBranchEntity);
        Assertions.assertEquals(existBranchEntity.getPosition(), NewStatus);
        Assertions.assertNotEquals(existBranchEntity.getPosition(), InitStatus);
    }
}
