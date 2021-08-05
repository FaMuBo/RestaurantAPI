package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entity.CardInfo;
import com.exampleFinartz.demo.repositories.CardInfoRepository;
import com.exampleFinartz.demo.services.CardInfoService;
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
public class CardInfoServiceTest {

    private static final String CARD_NAME_ZIRAAT = "Ziraat";
    private static final String CARD_NAME_GARANTI = "Garanti";

    @InjectMocks
    private CardInfoService cardInfoService;
    @Mock
    private CardInfoRepository cardInfoRepository;

    @Test
    public void ReturnAllCardInfo() {
        CardInfo cardInfo1 = CardInfo.builder().id(1L).build();
        CardInfo cardInfo2 = CardInfo.builder().id(2L).build();

        List<CardInfo> cardInfoList = Arrays.asList(cardInfo1, cardInfo2);
        Mockito.when(cardInfoRepository.findAll()).thenReturn(cardInfoList);

        List<CardInfo> fetchedList = cardInfoService.getAll();
        assertEquals(cardInfoList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCardInfo() {
        CardInfo cardInfo = CardInfo.builder().id(1L).name(CARD_NAME_ZIRAAT).build();
        Mockito.when(cardInfoRepository.getById(1L)).thenReturn(cardInfo);
        CardInfo fetchedCardInfo = cardInfoService.getById(1L);
        assertEquals(cardInfo.getId(), fetchedCardInfo.getId());
    }

    @Test
    public void ReturnSavedCardInfo() {
        CardInfo cardInfo = CardInfo.builder().build();
        Mockito.doReturn(cardInfo).when(cardInfoRepository).save(cardInfo);
        CardInfo returnedCardInfo = cardInfoService.create(cardInfo);
    }

    @Test
    public void ReturnUpdatedCardInfo() {
        CardInfo existCardInfo = CardInfo.builder().id(1L).name(CARD_NAME_ZIRAAT).build();
        CardInfo newCardInfo = CardInfo.builder().id(1L).name(CARD_NAME_GARANTI).build();

        Mockito.when(cardInfoRepository.getById(1L)).thenReturn(existCardInfo);
        Mockito.when(cardInfoRepository.save(newCardInfo)).thenReturn(newCardInfo);

        CardInfo updatedCardInfo = cardInfoService.update(newCardInfo);

        Assertions.assertNotEquals(existCardInfo.getName(), CARD_NAME_ZIRAAT);
        Assertions.assertEquals(existCardInfo.getName(), CARD_NAME_GARANTI);
    }
}




