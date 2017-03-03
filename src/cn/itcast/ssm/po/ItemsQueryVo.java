package cn.itcast.ssm.po;
/**
Byhouxuefeng
2017年3月3日
*/
public class ItemsQueryVo {
	//包装的po类
	//把items商品信息包进去，还包入扩展类
	private  ItemsCustom itemsCustom;
	private Items items;
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
}
