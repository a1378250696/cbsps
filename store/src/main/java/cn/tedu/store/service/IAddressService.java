package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;

/**
 * 处理收货地址 数据的业务 层接口
 * @author JAVA
 *
 */
public interface IAddressService {
	
	/**
	 * 增加收货地址数据
	 * @param uid 用户id
	 * @param username 用户名
	 * @param address 新的收货地址数据
	 */
	void addnew(Integer uid,String username,Address address);
	
	/**
	 * 将获取
	 * @param aid 当前登录地址id
	 * @param uid 当前登录地址
	 * @param username 当前用户名
	 */
	void setDefault(Integer aid,Integer uid,String username);
	
	/**
	 * 
	 * @param aid
	 * @param uid
	 * @param username
	 */
	void delete(Integer aid,Integer uid,String username);
	
	/**
	 * 获取某用户的收货地址列表
	 * @param uid 用户的id
	 * @return 该用户的收货地址列表
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 
	 * @param aid
	 * @param uid
	 * @return
	 */
	Address getbyAid(Integer aid,Integer uid);
	
}
