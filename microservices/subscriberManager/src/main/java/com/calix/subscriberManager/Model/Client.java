package com.calix.subscriberManager.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Client {
    String deviceName;
    String subscriberName;
    String connectionStatus;
    String properties;
}
