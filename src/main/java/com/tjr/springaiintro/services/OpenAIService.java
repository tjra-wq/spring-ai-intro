package com.tjr.springaiintro.services;

import com.tjr.springaiintro.model.Answer;
import com.tjr.springaiintro.model.GetCapitalRequest;
import com.tjr.springaiintro.model.Question;

public interface OpenAIService {
    String getAnswer(String question);
    Answer getAnswer(Question question);
    Answer getCapital(GetCapitalRequest stateOrCountry);
}
