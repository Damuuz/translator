package com.xmt.translator.assessment.translatorapi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    @Id
    private String word;
    private int ranking;
}
