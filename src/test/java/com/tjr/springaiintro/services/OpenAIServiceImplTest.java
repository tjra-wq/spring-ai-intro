package com.tjr.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {
    @Autowired
    OpenAIService openAIService;

    @Test
    void getAnswer() {
        String answer = openAIService.getAnswer("Write a python program to add two numbers");
        System.out.println("Answer: " + answer);

        String answer2 = openAIService.getAnswer("Write the game snake and ladder in python");
        System.out.println("Answer: " + answer2);

    }
}