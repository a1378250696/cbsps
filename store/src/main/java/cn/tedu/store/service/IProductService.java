package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Product;

public interface IProductService {
	
	/**
	 * 根据商品id，查询商品详情
	 * @param id 商品id
	 * @return 匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	Product getById(Integer id);

	/**
	 * 获取“新到好货”列表
	 * @return “新到好货”列表
	 */
	List<Product> getNewList();
	
}
