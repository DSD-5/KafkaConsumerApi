package com.tutiempolibro.kafka.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutiempolibro.kafka.clientes.EmailFeignClient;
import com.tutiempolibro.kafka.entity.SendSalesRent;

@Service
public class RentSalesConsumerBusiness {
	
	@Autowired
	private EmailFeignClient customerEmailClient;
	
	public SendSalesRent enviarFinalizarCompra(SendSalesRent send) {
		return customerEmailClient.enviarFinalizarCompra(send);
	}
}
