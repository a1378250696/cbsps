package cn.tedu.store.controller.ex;
/**
 * 上传的文件时出现输入输出异常
 * @author JAVA
 *
 */
public class FileUploadExcption extends RuntimeException{

	private static final long serialVersionUID = -8620022581585783649L;

	public FileUploadExcption() {
		super();
		
	}

	public FileUploadExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileUploadExcption(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileUploadExcption(String message) {
		super(message);
		
	}

	public FileUploadExcption(Throwable cause) {
		super(cause);
		
	}

}
