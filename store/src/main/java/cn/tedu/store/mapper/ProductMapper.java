package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Product;

/**
 * 处理商品数据的持久层接口
 * @author JAVA
 *
 */
public interface ProductMapper {
	
	/**
	 * 获取“新到好货”列表
	 * @return “新到好货”列表
	 */
	List<Product> findNewList();
	
	/**
	  * 根据商品id，查询商品详情
	 * @param id 商品id
	 * @return 匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	Product findById(Integer id);
	
	
}
