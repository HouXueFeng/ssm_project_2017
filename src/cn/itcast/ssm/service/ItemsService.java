package cn.itcast.ssm.service;
import java.util.List;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
/**
Byhouxuefeng
2017年3月3日
*/
public interface ItemsService {
	//查询商品列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	//按照id查询商品
	public ItemsCustom selectItemById(Integer id)throws Exception;
	//通过id修改商品信息
	public void updateItems(Integer id,ItemsCustom custom)throws Exception;
	//进行商品的批量删除
	public void deletedItems1(Integer[] items_id)throws Exception;

}
