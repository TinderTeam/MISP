package cn.fuego.misp.web.util.forecom.exception;

public class ForeComException extends RuntimeException
{
	/**
	 * 
	 */

	public ForeComException()
	{
		super();
	}

	public ForeComException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		// super(message, cause, enableSuppression, writableStackTrace);
	}

	public ForeComException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ForeComException(String message)
	{
		super(message);
	}

	public ForeComException(Throwable cause)
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
