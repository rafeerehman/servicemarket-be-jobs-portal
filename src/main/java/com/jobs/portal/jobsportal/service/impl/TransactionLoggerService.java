package com.jobs.portal.jobsportal.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobs.portal.jobsportal.entity.TransactionLoggerEntity;
import com.jobs.portal.jobsportal.repository.TransactionLoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TransactionLoggerService {

    @Autowired
    TransactionLoggerRepository repository;

    public void log(String trxId, String url, Object request, Object response, String method){
        try{
            ObjectMapper Obj = new ObjectMapper();
            String requestStr = "{}";
            if(request !=null){
                requestStr = Obj.writeValueAsString(request);
            }

            String responseStr = "{}";
            if(response != null){
                responseStr = Obj.writeValueAsString(response);
            }
            TransactionLoggerEntity entity = TransactionLoggerEntity.builder()
                    .requestJson(requestStr).responseJson(responseStr).transactionId(trxId)
                    .time(new Timestamp(System.currentTimeMillis())).method(method).url(url).build();

            repository.save(entity);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}


