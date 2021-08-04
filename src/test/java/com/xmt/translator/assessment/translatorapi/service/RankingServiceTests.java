package com.xmt.translator.assessment.translatorapi.service;

import com.xmt.translator.assessment.translatorapi.TranslatorApiApplicationTests;
import com.xmt.translator.assessment.translatorapi.data.Ranking;
import com.xmt.translator.assessment.translatorapi.data.RankingRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class RankingServiceTests extends TranslatorApiApplicationTests {
    @Autowired
    RankingService rankingService;
    @Autowired
    TranslatorService translatorService;
    @Autowired
    RankingRepository rankingRepository;

    @Test
    public void testCreate() throws IOException {
        translatorService.translateSentence("Ala ma kota");
        List<Ranking> rankings = rankingService.findAll();
        assertNotNull(rankings);
    }
}
