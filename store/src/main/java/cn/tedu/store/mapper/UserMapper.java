package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据增删改查的持久层接口
 * @author JAVA
 *
 */
public interface UserMapper {
	
	/**
	 * 插入用户数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据,如果没有匹配 的数据,则返回null
	 */
	User findByUsername(String username);
	
	/**
	 * 根据用户的id查询用户数据
	 * @param uid 用户id
	 * @param password 新密码
	 * @param modifiedUser 修改人
	 * @param modifiedTime 最后修改时间
	 * @return
	 */
	Integer updatePasswordByUid(
			@Param("uid")Integer uid,
			@Param("password")String password,
			@Param("modifiedUser")String modifiedUser,
			@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 修改用户资料
	 * @param user 封装了用户的id挤新资料的对象,可以封装手机号码.邮箱.性别
	 * @return 受影响的行数
	 */
	Integer updateInfoByUid(User user);
	
	/**
	 * 更新某用户头像的数据
	 * @param uid 用户id
	 * @param avatar 新头像
	 * @param modifiedUser 修改人
	 * @param modifiedTime 最后修改时间
	 * @return
	 */
	Integer updateAvatarByUid(
			@Param("uid")Integer uid,
			@Param("avatar")String avatar,
			@Param("modifiedUser")String modifiedUser,
			@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 根据用户的id查询用户数据
	 * @param uid 用户id
	 * @return 匹配的用户数据,如果没有则返回null,有则返回
	 */
	User findByUid(Integer uid);
	
	
	
}
