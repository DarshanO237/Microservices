package com.calix.subscriberManager.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor

public class DeviceSubscriber implements Serializable {

    private Integer subscriberId;
    private String name;
    private String connectionStatus;
    private String properties;

    public DeviceSubscriber(Integer subscriberId, String name, String connectionStatus, String properties) {
        this.subscriberId = subscriberId;
        this.name = name;
        this.connectionStatus = connectionStatus;
        this.properties = properties;
    }

    public DeviceSubscriber(String name, String connectionStatus, String properties) {
        this.name = name;
        this.connectionStatus = connectionStatus;
        this.properties = properties;
    }
}
