package com.tjr.springaiintro.controllers;

import com.tjr.springaiintro.model.Answer;
import com.tjr.springaiintro.model.GetCapitalRequest;
import com.tjr.springaiintro.model.Question;
import com.tjr.springaiintro.services.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }

    @PostMapping("/getCapital")
    public Answer getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
        return openAIService.getCapital(getCapitalRequest);
    }
}
