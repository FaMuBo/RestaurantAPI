package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.CardInfo;
import com.exampleFinartz.demo.repositories.CardInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardInfoService {
    public CardInfoService(CardInfoRepository cardInfoRepository) {

        this.cardInfoRepository = cardInfoRepository;
    }

    private final CardInfoRepository cardInfoRepository;

    public List<CardInfo> findAll() {
        return cardInfoRepository.findAll();
    }

    public CardInfo findById(Long id) {
        return cardInfoRepository.getById(id);
    }

    public CardInfo getById(Long id) {
        return cardInfoRepository.getById(id);
    }

    public List<CardInfo> getAll() {
        return cardInfoRepository.findAll();
    }

    public CardInfo create(CardInfo cardsInfo) {
        return cardInfoRepository.save(cardsInfo);
    }

    public CardInfo update(CardInfo cardInfo) {
        CardInfo foundCardsInfo = cardInfoRepository.getById(cardInfo.getId());
        if (cardInfo.getName() != null) {
            foundCardsInfo.setName(cardInfo.getName());
        }
        return cardInfoRepository.save(cardInfo);
    }

    public void deleteById(Long id) {
        cardInfoRepository.deleteById(id);
    }

    public String delete(long id) {
        cardInfoRepository.deleteById(id);
        return "SUCCESS";
    }
}

