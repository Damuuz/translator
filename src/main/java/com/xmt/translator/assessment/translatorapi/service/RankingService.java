package com.xmt.translator.assessment.translatorapi.service;

import com.xmt.translator.assessment.translatorapi.data.Ranking;
import com.xmt.translator.assessment.translatorapi.data.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    RankingRepository rankingRepository;

    public void create(Ranking ranking) {
        rankingRepository.save(ranking);
    }

    public List<Ranking> findAll() {
        //Sort sort = new Sort(Sort.Direction.DESC);
        return rankingRepository.findAll();
    }

    public Ranking getOne(String word) {
        return rankingRepository.findByWord(word);
    }
}
