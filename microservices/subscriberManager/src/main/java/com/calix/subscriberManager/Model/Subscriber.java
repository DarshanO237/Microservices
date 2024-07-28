package com.calix.subscriberManager.Model;


import jakarta.persistence.*;;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Getter
@Setter
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscriberID;
    private Integer deviceID;
    private String subscriberName;
    private String connectionStatus;
    private String deviceName;

}
