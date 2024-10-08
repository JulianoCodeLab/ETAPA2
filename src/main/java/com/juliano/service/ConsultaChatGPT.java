package com.juliano.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

        public static String obterTraducao(String texto) {

            OpenAiService service = new OpenAiService("sk-proj- qVUKVbaZzSEZxGJcj9ART3BlbkFJdNb3JBiImy2fpF1fy41o");

// chave expirou. Cadastre-se e solicite uma nova chave
            CompletionRequest requisicao = CompletionRequest.builder()
                    .model("gpt-3.5-turbo-instruct")
                    .prompt("traduza para o português o texto: " + texto)
                    .maxTokens(1000)
                    .temperature(0.7)
                    .build();
            var resposta = service.createCompletion(requisicao);
            return resposta.getChoices().get(0).getText();
        }
}

