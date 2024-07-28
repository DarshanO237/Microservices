package com.calix.subscriberManager;

import com.calix.subscriberManager.Model.Subscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SubscriberManagerApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SubscriberManagerApplication.class, args);
		//SubscriberDataRepo repo=context.getBean(SubscriberDataRepo.class);
		Subscriber s1=context.getBean(Subscriber.class);
//		s1.setDeviceID(2);
//		s1.setConnectionStatus("yes");
//		s1.setSubscriberName("subscriber2");
//		repo.save(s1);
//		System.out.println(repo.findAll());

	}

}
