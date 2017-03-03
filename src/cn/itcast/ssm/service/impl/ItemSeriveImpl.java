package cn.itcast.ssm.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/**
Byhouxuefeng
2017年3月3日
*/
//service接口
public class ItemSeriveImpl implements ItemsService{
	@Autowired
	//这里使用自动注入的方式因为 配置mapper扫描器时自动扫描了接口
	private ItemsMapperCustom itemsMapperCustom;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
}
