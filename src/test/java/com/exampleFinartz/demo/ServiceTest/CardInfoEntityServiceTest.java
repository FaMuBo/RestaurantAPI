//package com.exampleFinartz.demo.ServiceTest;
//
//
//import com.exampleFinartz.demo.models.entity.CardInfoEntity;
//import com.exampleFinartz.demo.repositories.CardInfoRepository;
//import com.exampleFinartz.demo.services.CardInfoService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class CardInfoEntityServiceTest {
//
//    private static final String CARD_NAME_ZIRAAT = "Ziraat";
//    private static final String CARD_NAME_GARANTI = "Garanti";
//
//    @InjectMocks
//    private CardInfoService cardInfoService;
//    @Mock
//    private CardInfoRepository cardInfoRepository;
//
//    @Test
//    public void ReturnAllCardInfo() {
//        CardInfoEntity cardInfoEntity1 = CardInfoEntity.builder().id(1L).build();
//        CardInfoEntity cardInfoEntity2 = CardInfoEntity.builder().id(2L).build();
//
//        List<CardInfoEntity> cardInfoEntityList = Arrays.asList(cardInfoEntity1, cardInfoEntity2);
//        Mockito.when(cardInfoRepository.findAll()).thenReturn(cardInfoEntityList);
//
//        List<CardInfoEntity> fetchedList = cardInfoService.getAll();
//        assertEquals(cardInfoEntityList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnCardInfo() {
//        CardInfoEntity cardInfoEntity = CardInfoEntity.builder().id(1L).name(CARD_NAME_ZIRAAT).build();
//        Mockito.when(cardInfoRepository.getById(1L)).thenReturn(cardInfoEntity);
//        CardInfoEntity fetchedCardInfoEntity = cardInfoService.getById(1L);
//        assertEquals(cardInfoEntity.getId(), fetchedCardInfoEntity.getId());
//    }
//
//    @Test
//    public void ReturnSavedCardInfo() {
//        CardInfoEntity cardInfoEntity = CardInfoEntity.builder().build();
//        Mockito.doReturn(cardInfoEntity).when(cardInfoRepository).save(cardInfoEntity);
//        CardInfoEntity returnedCardInfoEntity = cardInfoService.create(cardInfoEntity);
//    }
//
//    @Test
//    public void ReturnUpdatedCardInfo() {
//        CardInfoEntity existCardInfoEntity = CardInfoEntity.builder().id(1L).name(CARD_NAME_ZIRAAT).build();
//        CardInfoEntity newCardInfoEntity = CardInfoEntity.builder().id(1L).name(CARD_NAME_GARANTI).build();
//
//        Mockito.when(cardInfoRepository.getById(1L)).thenReturn(existCardInfoEntity);
//        Mockito.when(cardInfoRepository.save(newCardInfoEntity)).thenReturn(newCardInfoEntity);
//
//        CardInfoEntity updatedCardInfoEntity = cardInfoService.update(newCardInfoEntity);
//
//        Assertions.assertNotEquals(existCardInfoEntity.getName(), CARD_NAME_ZIRAAT);
//        Assertions.assertEquals(existCardInfoEntity.getName(), CARD_NAME_GARANTI);
//    }
//}
//
//
//
//
