package cn.tedu.store.service.ex;
/**
 * 插入数据异常
 * @author JAVA
 *
 */
public class InsertException extends ServiceException{

	private static final long serialVersionUID = -683317900664631053L;

	public InsertException() {
		super();
	}

	public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertException(String message) {
		super(message);
	}

	public InsertException(Throwable cause) {
		super(cause);
	}

	
	
}
