package com.tjr.springaiintro.services;

import com.tjr.springaiintro.model.Answer;
import com.tjr.springaiintro.model.GetCapitalRequest;
import com.tjr.springaiintro.model.Question;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenAIServiceImpl.class);

    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    @Override
    public String getAnswer(String question) {
        log.info("Question: " + question);
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();

        ChatResponse chatResponse = chatModel.call(prompt);
        return chatResponse.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        log.info("Question: " + question);
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();

        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getContent());
    }

    @Override
    public Answer getCapital(GetCapitalRequest stateOrCountry) {
        log.info("Question: " + stateOrCountry);
//        PromptTemplate promptTemplate = new PromptTemplate(stateOrCountry.stateOrCountry());
//        PromptTemplate promptTemplate = new PromptTemplate("What is the Capital of " + stateOrCountry.stateOrCountry() + "?");
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", stateOrCountry.stateOrCountry()));

        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getContent());
    }
}
