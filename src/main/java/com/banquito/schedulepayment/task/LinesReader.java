package com.banquito.schedulepayment.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.banquito.schedulepayment.collection.dto.CollectionOrderDTO;
import com.banquito.schedulepayment.payments.dto.ServiceOfferedDTO;

public class LinesReader implements Tasklet, StepExecutionListener {

    private static final String BASE_URL = "http://localhost:8080/serviceOffered";//implementar

    private static final String BASE_URL_COLLECTION = "http://localhost:8080/collection";//implementar 

    private final RestTemplate restTemplate;

    private List<ServiceOfferedDTO> servicesOffered;

    private ArrayList<CollectionOrderDTO> collectionOrderDTOs;

    public LinesReader() {
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
        this.collectionOrderDTOs = new ArrayList<>();
    }
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
        ResponseEntity<ServiceOfferedDTO[]> response = this.restTemplate.getForEntity(BASE_URL, ServiceOfferedDTO[].class);//Tratar de traer todos dependiendo de la fecha
        ServiceOfferedDTO[] objectArray = response.getBody();
        this.servicesOffered = Arrays.asList(objectArray);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        
        for(ServiceOfferedDTO serviOffered: this.servicesOffered){
            if(serviOffered.getFirstScheduleDate().compareTo(new Date())<=0 && serviOffered.getFinalScheduleDate().compareTo(new Date())>=0){
                ResponseEntity<CollectionOrderDTO> response = this.restTemplate.getForEntity(BASE_URL_COLLECTION+"/"+serviOffered.getReferenceId(), CollectionOrderDTO.class);//Obtener datos del cobro  
                CollectionOrderDTO objectArray = response.getBody();
                if(objectArray!=null)
                    collectionOrderDTOs.add(objectArray);
            }
        }
        return RepeatStatus.FINISHED;
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
