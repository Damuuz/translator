package com.xmt.translator.assessment.translatorapi.controller;

import com.xmt.translator.assessment.translatorapi.data.Ranking;
import com.xmt.translator.assessment.translatorapi.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RankingController.RANKING)
public class RankingController {
    public final static String RANKING = "ranking";
    public final static String LIST = "list";
    public final static String HOME = "/";
    public final static String HOME_LIST = HOME + LIST;

    @Autowired
    RankingService rankingService;
    @GetMapping(HOME_LIST)
    public List<Ranking> getAllRankings() {
        return rankingService.findAll();
    }
}
