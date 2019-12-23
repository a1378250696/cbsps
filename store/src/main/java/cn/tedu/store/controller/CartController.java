package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.JsonResult;
import cn.tedu.store.vo.CartVO;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
	
	@Autowired
	private ICartService service;
	
	@RequestMapping("add_to_cart")
	public JsonResult<Void> addToCart(Integer pid,Integer amount,HttpSession session){
	
	Integer uid = getUidFromSession(session);
	String username = getUsernameFromSession(session);
	service.addToCart(uid, username, pid, amount);
	
	return new JsonResult<>(ok);
	}
	
	@GetMapping({"","/"})
	public JsonResult<List<CartVO>> getVOByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVO> data = service.getVOByUid(uid);
		return new JsonResult<>(ok,data);
	}
	
	@RequestMapping("{cid}/num/add")
	public JsonResult<Integer> addNum(@PathVariable("cid")Integer cid,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		Integer data = service.addNum(cid, uid, username);
		
		return new JsonResult<>(ok,data);
	}
	
	@GetMapping({"get_by_cids"})
	public JsonResult<List<CartVO>> getVOByCids(Integer[] cids,HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVO> data = service.getVOByCids (cids,uid);
		return new JsonResult<>(ok,data);
	}
	
}
