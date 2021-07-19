package com.egg.domain.exception;

public class EntityInUseException extends TransactionalException {

	private static final long serialVersionUID = 1L;

	public EntityInUseException(String mensagem) {
		super(mensagem);
	}
	
}
