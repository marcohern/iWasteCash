package com.rocketteam.iwastecash.exceptions;

public abstract class IwasteCashException extends Exception {

	/**
	 * Serial Version UID or whatever
	 */
	private static final long serialVersionUID = 6066606273063270148L;
	
	public IwasteCashException() { super(); }
	public IwasteCashException(String message) { super(message); }
	public IwasteCashException(String message, Exception inner) { super(message, inner); }
}
