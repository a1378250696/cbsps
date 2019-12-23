package cn.tedu.store.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyExcption;
import cn.tedu.store.controller.ex.FileIOExcption;
import cn.tedu.store.controller.ex.FileSizeExcption;
import cn.tedu.store.controller.ex.FileStateExcption;
import cn.tedu.store.controller.ex.FileTypeExcption;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("users") // 业务层对象
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {

		// 调用userService的reg()方法实现注册
		userService.reg(user);
		// 返回
		return new JsonResult<Void>(ok);
	}

	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session) {
		// 调用userService的login()方法实现登录
		User user = userService.login(username, password);
		// 将uid.username存入到Session
		session.setAttribute("uid", user.getUid());
		session.setAttribute("username", user.getUsername());
		System.out.println("用户登入成功");
		System.err.println(user.getUid());
		System.err.println(user.getUsername());
		return new JsonResult<>(ok, user);
	}

	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
		// 从Session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService的login()方法实现功能
		userService.changePassword(uid, username, oldPassword, newPassword);
		// 返回
		return new JsonResult<>(ok);
	}

	@RequestMapping("change_info")
	public JsonResult<Void> changeInfo(User user, HttpSession session) {
		// 从Session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService的login()方法实现功能
		userService.changeInfo(uid, username, user);
		// 返回
		return new JsonResult<>(ok);
	}

	@GetMapping("info")
	public JsonResult<User> getInfo(HttpSession session) {

		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());

		// 调用userService的login()方法实现功能
		User user = userService.getInfo(uid);
		// 返回
		return new JsonResult<>(ok, user);

	}
	
	//当项目启动的时候,创建控制器,设定了上限值
	@Value("${project.upload.avatar.avatarmax-size}")	
	private int avatarmaxSize;
	private static final List<String> AVATART_TYPES = new ArrayList<>();
	//允许 文件上传类型
	static {
		AVATART_TYPES.add("image/jpeg");
		AVATART_TYPES.add("image/png");
	}
	
	@PostMapping("change_avatar")
	public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {
		// 长篇代码:倒着写,最小化
		
		//检查上传的文件是否为空
		if(file.isEmpty()) {
			throw new FileEmptyExcption("请选择你要上传的头像");
		}		
		
		//检查上传的文件大小
		if(file.getSize() > avatarmaxSize) {
			throw new FileSizeExcption("头像上传不允许超过"+ avatarmaxSize/1024 +"KB!");
		}
		
		//检查上传的文件类型:image/jpeg,image/png,
		if(!AVATART_TYPES.contains(file.getContentType())) {
			throw new FileTypeExcption("你的文件上传格式错误,请用这种类型上传:"+AVATART_TYPES);
		}
		
		// 获取原始文件名
		String originalFilename = file.getOriginalFilename();

		// 保存用户头像的文件夹
		String dir = session.getServletContext().getRealPath("upload");
		File dirFile = new File(dir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		// 保存上传的头像时使用的文件名
		String name = System.currentTimeMillis() + "-" + System.nanoTime();
		String suffix = "";
		int i = originalFilename.lastIndexOf(".");
		if (i > 0) {
			suffix = originalFilename.substring(i);
		}

		String filename = name + suffix;
		// 用户头像的路径(响应给客户端,且存入到数据库中)		
		String avatar = "/upload/" + filename;
		System.out.println("avatar=" + avatar);

		try {
			// 执行保存
			File dest = new File(dir, filename);
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new FileStateExcption("文件不存在,可能无法访问,请重新选择!");
		} catch (Exception e) {
			throw new FileIOExcption("读取文件出现异常,请重新上传!");
		}

		// 从Session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();

		userService.changeAvatar(uid, username, avatar);

		return new JsonResult<>(ok,avatar);

	}

}
