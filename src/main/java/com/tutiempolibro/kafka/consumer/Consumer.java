package com.tutiempolibro.kafka.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutiempolibro.kafka.business.CustomerConsumerBusiness;
import com.tutiempolibro.kafka.business.RentSalesConsumerBusiness;

import lombok.experimental.var;

@Service
public class Consumer {
	
	@Autowired
	private CustomerConsumerBusiness customerConsumerBusiness;
	
	@Autowired
	private RentSalesConsumerBusiness rentSalesConsumerBusiness;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "t_customer_creation")
	public void consume(String message) throws JsonParseException, JsonMappingException, IOException {
		var send = objectMapper.readValue(message, com.tutiempolibro.kafka.entity.SendEmail.class);
		log.info("SendEmail is {}", send);
		customerConsumerBusiness.enviarRegUsuario(send);
		log.info("Resultado : ", send.isEnvio());
	}
	
	
	@KafkaListener(topics = "t_rentsales_finish")
	public void consumeRentSales(String message) throws JsonParseException, JsonMappingException, IOException {
		var send = objectMapper.readValue(message, com.tutiempolibro.kafka.entity.SendSalesRent.class);
		log.info("SendRentSales is {}", send);
		rentSalesConsumerBusiness.enviarFinalizarCompra(send);
		log.info("Resultado RentSales : ", send.isEnvio());
	}
	
}
