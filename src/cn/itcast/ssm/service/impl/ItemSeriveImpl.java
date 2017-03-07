package cn.itcast.ssm.service.impl;
import java.awt.Image;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
/**
Byhouxuefeng
2017年3月3日
*/
//service接口
public class ItemSeriveImpl implements ItemsService{
	
	//这里使用自动注入的方式因为 配置mapper扫描器时自动扫描了接口
	@Autowired		
	private ItemsMapperCustom itemsMapperCustom;//扩展
	@Autowired
	private ItemsMapper itemsMapper;//逆向工程中的
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	
	@Override
	public ItemsCustom selectItemById(Integer id) throws Exception {
		//这里使用了扩展类型
		ItemsCustom itemsCustom=new ItemsCustom();

		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间对商品信息进行业务处理
		//将items的信息拷贝到ItemsCustom中去
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}
	
	//修改的时候必须通过id进行修改
	@Override
	public void updateItems(Integer id,ItemsCustom custom) throws Exception {
		custom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(custom);
	}

	//进行商品的批量删除
	@Override
	public void deletedItems1(Integer[] items_id) throws Exception {
		itemsMapperCustom.deletedItems(items_id);
		
	}

	@Override
	public void updateBatch1(ItemsQueryVo itemsQueryVo) throws Exception {

		itemsMapperCustom.updateBatch(itemsQueryVo);
	}

	

	
}
