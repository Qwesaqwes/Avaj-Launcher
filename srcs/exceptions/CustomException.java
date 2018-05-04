package srcs.exceptions;
import java.lang.Exception;

public class CustomException extends Exception
{
	public CustomException() {};
	public CustomException(String str)
	{
		super(str);
	}
}
