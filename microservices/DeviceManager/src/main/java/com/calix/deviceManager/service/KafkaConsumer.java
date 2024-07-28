package com.calix.deviceManager.service;

import com.calix.deviceManager.model.Device;
import com.calix.deviceManager.model.DeviceSubscriber;

import com.calix.deviceManager.model.SubscriberDTO;
import com.calix.deviceManager.repo.DeviceRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate2;
    @Autowired
    private DeviceRepo repo;

    @KafkaListener(topics = "Device-1", groupId = "group-1")
    public void listenToTopic(DeviceSubscriber d) {
        try {
            logger.info("Kafka consumer got the Device");

            Device savedDevice = new Device(d.getName(), d.getConnectionStatus(), d.getProperties());
            repo.save(savedDevice);
            logger.info("Device added to Database");

            int id = savedDevice.getId();
            SubscriberDTO s = new SubscriberDTO();
            s.setSubscriberID(d.getSubscriberId());
            s.setDeviceID(id);
            s.setDeviceName(savedDevice.getName());
            System.out.println(s);

            kafkaTemplate2.send("Subscriber-2", new ObjectMapper().writeValueAsString(s));
            logger.info("id sent to manager via kafka");
        } catch (Exception e) {
            logger.error("Exception occurred in kafkaConsumer:", e);

        }


    }

}

