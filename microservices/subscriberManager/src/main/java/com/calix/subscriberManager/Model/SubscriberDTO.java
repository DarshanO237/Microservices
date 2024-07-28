package com.calix.subscriberManager.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubscriberDTO implements Serializable {
    int deviceID;
    int subscriberID;
    String deviceName;
}
