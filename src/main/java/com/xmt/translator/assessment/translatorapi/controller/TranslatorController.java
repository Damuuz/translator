package com.xmt.translator.assessment.translatorapi.controller;

import com.xmt.translator.assessment.translatorapi.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(TranslatorController.TRANSLATOR)
public class TranslatorController {
    public static final String TRANSLATOR = "translator";
    public static final String HOME = "/";
    public static final String SENTENCE = "sentence";
    public static final String QUOTES = "quotes";
    public static final String HOME_QUOTES = HOME + QUOTES;

    @Autowired
    TranslatorService translatorService;

    @PostMapping
    public String getTranslation(@RequestParam(SENTENCE) String sentence) {
        String translatedSentence;
        try {
            translatedSentence = translatorService.translateSentence(sentence);

        } catch (IOException e) {
            translatedSentence = e.getStackTrace().toString();
        }
        return translatedSentence;
    }

    @PostMapping(HOME_QUOTES)
    public String getTranslationInQuotes(@RequestParam(SENTENCE) String sentence) {
        String translatedSentence;
        try {
            translatedSentence = translatorService.translateSentenceInQuotes(sentence);

        } catch (IOException e) {
            translatedSentence = e.getStackTrace().toString();
        }
        return translatedSentence;
    }

}
