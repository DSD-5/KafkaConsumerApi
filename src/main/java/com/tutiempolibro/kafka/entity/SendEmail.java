package com.tutiempolibro.kafka.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class SendEmail implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idpersona;
	private String correo;
	private String tipocorreo;
	private com.tutiempolibro.kafka.entity.Usuario usuario;
	
	private boolean envio;

}
