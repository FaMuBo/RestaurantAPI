package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.entity.CardInfoEntity;
import com.exampleFinartz.demo.repositories.CardInfoRepository;
import com.exampleFinartz.demo.services.CardInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardInfoServiceImpl implements CardInfoService {

    private final CardInfoRepository cardInfoRepository;

    public CardInfoServiceImpl(CardInfoRepository CardInfoRepository) {
        this.cardInfoRepository = CardInfoRepository;
    }

    public List<CardInfoEntity> findAll() {
        return cardInfoRepository.findAll();
    }

    public CardInfoEntity findById(Long id) {
        return cardInfoRepository.getById(id);
    }

    @Override
    public CardInfoEntity getById(Long id) {
        return cardInfoRepository.getById(id);
    }

    @Override
    public List<CardInfoEntity> getAll() {
        return cardInfoRepository.findAll();
    }

    @Override
    public CardInfoEntity create(CardInfoEntity cardsInfo) {
        return cardInfoRepository.save(cardsInfo);
    }

    @Override
    public CardInfoEntity update(CardInfoEntity cardInfoEntity) {
        CardInfoEntity foundCardsInfo = cardInfoRepository.getById(cardInfoEntity.getId());
        if (cardInfoEntity.getName() != null) {
            foundCardsInfo.setName(cardInfoEntity.getName());
        }
        return cardInfoRepository.save(cardInfoEntity);
    }

    @Override
    public CardInfoEntity deleteById(Long id) {
        CardInfoEntity cardInfoEntity = cardInfoRepository.getById(id);
        if (cardInfoEntity != null) {
            cardInfoRepository.deleteById(id);
            return cardInfoEntity;
        }
        return cardInfoEntity;
    }

    @Override
    public String delete(Long id) {
        cardInfoRepository.deleteById(id);
        return "SUCCESS";
    }

}
