package com.xmt.translator.assessment.translatorapi.service;

import com.xmt.translator.assessment.translatorapi.data.Ranking;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@Service
public class TranslatorService {
    @Autowired
    RankingService rankingService;
    @Value("data/dictionary.json")
    private String resourceFile;
    private Log log = LogFactory.getLog(this.getClass().getName());

    public String[] readFile() throws IOException {
        File resource = new ClassPathResource(resourceFile).getFile();
        String dictionary = new String(
                Files.readAllBytes(resource.toPath())
        );
        String[] dictionaryArray = dictionary.split(",");
        return dictionaryArray;
    }

    public String translateSentence(String sentence) throws IOException {
        String[] sentenceArray = sentence.split(" ");
        String[] dictionaryArray = readFile();
        String translatedSentence = matchWords(sentenceArray, dictionaryArray);
        return translatedSentence;
    }

    public String translateSentenceInQuotes(String sentence) throws IOException {
        String[] sentenceArray = sentence.split(" ");
        String[] dictionaryArray = readFile();
        String translatedSentence = matchWordsWithInQuotes(sentenceArray, dictionaryArray);
        return translatedSentence;
    }

    public String matchWords(String[] sentenceArray, String[] dictionaryArray) {
        String translatedSentence = "";
        Ranking ranking = new Ranking();
        for (String word : sentenceArray) {
            for (int i = 0; i < dictionaryArray.length; i++) {
                String line = dictionaryArray[i].replaceAll("\\n", "");
                if (line.contains(word)) {
                    int index = line.indexOf(':');
                    String matchedWord = line.substring(index + 3, line.length() - 1);
                    translatedSentence = translatedSentence + " " + matchedWord;


                }
            }
            ranking.setWord(word);
            int rank = ranking.getRanking() + 1;
            ranking.setRanking(rank);
            rankingService.create(ranking);
        }
        return translatedSentence;
    }

    public String matchWordsWithInQuotes(String[] sentenceArray, String[] dictionaryArray) {
        String translatedSentence = "";
        for (String word : sentenceArray) {
            for (int i = 0; i < dictionaryArray.length; i++) {
                String line = dictionaryArray[i].replaceAll("\\n", "");
                if (line.contains(word)) {
                    int index = line.indexOf(':');
                    String matchedWord = line.substring(index + 2, line.length());
                    translatedSentence = translatedSentence + " " + matchedWord;
                }
            }
        }
        return translatedSentence;
    }


}
