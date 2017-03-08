package cn.itcast.ssm.po;

import java.util.List;

/**
Byhouxuefeng
2017年3月3日
*/
public class ItemsQueryVo {
	//包装的po类
	private  ItemsCustom itemsCustom;
	//进行批量修改的集合（参数绑定list集合）
	//将修改的信息放到包装类的List集合itemsList中
	private List<ItemsCustom>itemsList;
	
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
}
