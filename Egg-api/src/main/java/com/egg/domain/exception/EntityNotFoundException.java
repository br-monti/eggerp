package com.egg.domain.exception;

public abstract class EntityNotFoundException extends TransactionalException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}
	
}