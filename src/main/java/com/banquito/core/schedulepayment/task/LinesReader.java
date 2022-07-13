package com.banquito.core.schedulepayment.task;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class LinesReader implements Tasklet, StepExecutionListener {

    private static final String BASE_URL = "http://localhost:8080/products";

    private final RestTemplate restTemplate;

    public LinesReader() {
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }
    @Override
    public void beforeStep(StepExecution stepExecution) {
        // TODO Auto-generated method stub
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // TODO Auto-generated method stub
        return null;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        int connectTimeout = 5000;
        int readTimeout = 5000;
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return clientHttpRequestFactory;
    }
}
