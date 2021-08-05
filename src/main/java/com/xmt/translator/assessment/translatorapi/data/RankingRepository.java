package com.xmt.translator.assessment.translatorapi.data;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface RankingRepository extends MongoRepository<Ranking, String> {
    Ranking findByWord(String word);
}
