package com.xmt.translator.assessment.translatorapi.service;


import com.xmt.translator.assessment.translatorapi.TranslatorApiApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class translatorServiceTests extends TranslatorApiApplicationTests {
    @Autowired
    private TranslatorService translatorService;

    @Test
    public void readFileTest() throws IOException {
        translatorService.readFile();
    }

    @Test
    public void translateSentence() throws IOException {
        translatorService.translateSentence("Ala ma kota");
    }

    @Test
    public void translateSentenceInQuotes() throws IOException {
        translatorService.translateSentenceInQuotes("Ala ma kota");
    }
}
