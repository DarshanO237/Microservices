package com.calix.subscriberManager.service;

import com.calix.subscriberManager.Model.Subscriber;
import com.calix.subscriberManager.Model.DeviceSubscriber;
import com.calix.subscriberManager.Model.SubscriberDTO;
import com.calix.subscriberManager.fiegn.FeignService;
import com.calix.subscriberManager.repo.SubscriberRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements SubscriberServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberService.class);
    @Autowired
    private SubscriberRepo repo;
    @Autowired
    FeignService FeignService;

    public ResponseEntity<String> addData(Subscriber s) {
        try {
            Subscriber s1 = repo.save(s);
            return new ResponseEntity<>("Success added new  Subscriber Data Entry", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error could not add  Subscriber Data Entry ", HttpStatus.BAD_REQUEST);


    }

    public List<Subscriber> getSubscriberData() {

        return repo.findAll();

    }

    @KafkaListener(topics = "Subscriber-2", groupId = "group-2")
    public void updateSubscriberData(String s) {
        try {
           logger.info("message received from kafka");
            if (s != null && !s.isEmpty()) {
                SubscriberDTO sub = new ObjectMapper().readValue(s, SubscriberDTO.class);
                Subscriber s1 = repo.findById(sub.getSubscriberID());
                s1.setDeviceID(sub.getDeviceID());
                repo.save(s1);
            }


        } catch (Exception ex) {
            logger.error("Error in getting message from kafka");
            ex.printStackTrace();
        }

    }


    public ResponseEntity<String> addClientData(String deviceName, String subscriberName, String connectionStatus, String properties) {

        Subscriber s = new Subscriber();
        s.setConnectionStatus(connectionStatus);
        s.setSubscriberName(subscriberName);
        s.setDeviceName(deviceName);
        repo.save(s);
        Integer sid = s.getSubscriberID();
        DeviceSubscriber d = new DeviceSubscriber(sid, deviceName, connectionStatus, properties);
        return FeignService.addCustomer(d);

    }


}