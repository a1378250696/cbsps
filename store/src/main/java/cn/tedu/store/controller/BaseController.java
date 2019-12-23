package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.controller.ex.FileEmptyExcption;
import cn.tedu.store.controller.ex.FileIOExcption;
import cn.tedu.store.controller.ex.FileSizeExcption;
import cn.tedu.store.controller.ex.FileStateExcption;
import cn.tedu.store.controller.ex.FileTypeExcption;
import cn.tedu.store.controller.ex.FileUploadExcption;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressCountLimitException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ProductNotFoundException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

/**
 * 控制器的基类
 * 
 * @author JAVA
 *
 */
public abstract class BaseController {

	/**
	 * 操作成功时的状态码
	 */
	public static final int ok = 2000;
	
	/**
	 * 从Session中获取当前登录的用户的id
	 * @param session HttpSession对象
	 * @return 登录的用户的id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}
	

	@ExceptionHandler({ ServiceException.class,FileUploadExcption.class })
	public JsonResult<Void> HandleException(Throwable e) {
		JsonResult<Void> jr = new JsonResult<Void>(e);

		if (e instanceof UsernameDuplicateException) {
			jr.setState(4004);
		} else if (e instanceof UserNotFoundException) {
			jr.setState(40041);
		} else if (e instanceof PasswordNotMatchException) {
			jr.setState(40042);
		} else if (e instanceof InsertException) {
			jr.setState(5000);
		} else if (e instanceof UpdateException) {
			jr.setState(5001);
		} else if (e instanceof FileTypeExcption) {
			jr.setState(4045);
		} else if (e instanceof FileStateExcption) {
			jr.setState(4046);
		} else if (e instanceof FileSizeExcption) {
			jr.setState(4047);
		} else if (e instanceof FileIOExcption) {
			jr.setState(4048);
		} else if (e instanceof FileEmptyExcption) {
			jr.setState(4049);
		} else if (e instanceof AddressCountLimitException) {
			jr.setState(6000);
		} else if (e instanceof AccessDeniedException) {
			jr.setState(6001);
		} else if (e instanceof AddressNotFoundException) {
			jr.setState(6002);
		} else if (e instanceof ProductNotFoundException) {
			jr.setState(6003);
		} else if (e instanceof CartNotFoundException) {
			jr.setState(6004);
		}

		return jr;
	}

}
