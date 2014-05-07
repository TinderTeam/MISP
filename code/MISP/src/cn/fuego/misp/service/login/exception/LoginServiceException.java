package cn.fuego.misp.service.login.exception;

import cn.fuego.misp.service.exception.ServiceException;

public class LoginServiceException extends ServiceException{
	/**
	 * 
	 */

	public LoginServiceException()
	{
		super();
	}

	public LoginServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		// super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LoginServiceException(String message)
	{
		super(message);
	}

	public LoginServiceException(Throwable cause)
	{
		super(cause);
	}

	@Override
	public String toString()
	{
		String message = getLocalizedMessage();
		return (message != null) ? (message) : "";

	}
}
