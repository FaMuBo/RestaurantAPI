package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.CardInfo;
import com.exampleFinartz.demo.repositories.CardInfoRepository;
import com.exampleFinartz.demo.services.CardInfoService;

import java.util.List;

public class CardInfoServiceImpl implements CardInfoService {

    private final CardInfoRepository cardInfoRepository;

    public CardInfoServiceImpl(CardInfoRepository CardInfoRepository) {
        this.cardInfoRepository = CardInfoRepository;
    }

    public List<CardInfo> findAll() {
        return cardInfoRepository.findAll();
    }

    public CardInfo findById(Long id) {
        return cardInfoRepository.getById(id);
    }

    @Override
    public CardInfo getById(Long id) {
        return cardInfoRepository.getById(id);
    }

    @Override
    public List<CardInfo> getAll() {
        return cardInfoRepository.findAll();
    }

    @Override
    public CardInfo create(CardInfo cardsInfo) {
        return cardInfoRepository.save(cardsInfo);
    }

    @Override
    public CardInfo update(CardInfo cardInfo) {
        CardInfo foundCardsInfo = cardInfoRepository.getById(cardInfo.getId());
        if (cardInfo.getName() != null) {
            foundCardsInfo.setName(cardInfo.getName());
        }
        return cardInfoRepository.save(cardInfo);
    }

    @Override
    public CardInfo deleteById(Long id) {
        CardInfo cardInfo = cardInfoRepository.getById(id);
        if (cardInfo != null) {
            cardInfoRepository.deleteById(id);
            return cardInfo;
        }
        return cardInfo;
    }

    @Override
    public String delete(Long id) {
        cardInfoRepository.deleteById(id);
        return "SUCCESS";
    }

}
