package com.tutiempolibro.kafka.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tutiempolibro.kafka.entity.SendEmail;
import com.tutiempolibro.kafka.entity.SendSalesRent;

@FeignClient(name="email-service")
public interface EmailFeignClient {
	
	@PostMapping("/v1/email/envioregusuario")
	public SendEmail enviarRegUsuario(@RequestBody SendEmail send);
	
	
	@PostMapping("/v1/email/enviofinalizarcompra")
	public SendSalesRent enviarFinalizarCompra(@RequestBody SendSalesRent send) ;
	
	
	
}
