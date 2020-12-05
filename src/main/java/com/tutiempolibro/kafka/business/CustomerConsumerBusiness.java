package com.tutiempolibro.kafka.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutiempolibro.kafka.clientes.EmailFeignClient;
import com.tutiempolibro.kafka.entity.SendEmail;

@Service
public class CustomerConsumerBusiness {
	
	@Autowired
	private EmailFeignClient customerEmailClient;
	
	public SendEmail enviarRegUsuario(SendEmail send) {
		
		return customerEmailClient.enviarRegUsuario(send);
	}
	
}
