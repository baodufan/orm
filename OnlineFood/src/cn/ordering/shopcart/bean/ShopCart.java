package cn.ordering.shopcart.bean;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
/**
 * 购物车实体类
 * @author baodu
 *
 */
import java.util.Map;

import javax.xml.ws.RespectBinding;

import com.sun.xml.internal.ws.Closeable;

public class ShopCart {
	
	private Map<Integer, ShopCartitem>map=new HashMap<Integer, ShopCartitem>(); //定义购物车集合封装购物车条目类
	
	public Map<Integer, ShopCartitem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, ShopCartitem> map) {
		this.map = map;
	}

	//价格合计计算
	public double getTotal(){
		BigDecimal total=new BigDecimal("0");
		for(ShopCartitem sct:map.values()){
			BigDecimal bg=new BigDecimal(sct.getSubtotal()+"");
			total=total.add(bg);
		}
		return total.doubleValue();
	}
	
	//添加商品条目到购物车
	public void addShopcartitem(ShopCartitem sct){
		if(map.containsKey(sct.getItem().getItemId())){ //判断购物车是否存在商品
			ShopCartitem sc=map.get(sct.getItem().getItemId());  //取出原来的商品条目
			sc.setNum(sc.getNum()+sct.getNum());  //设置新的数量加上原来的数量
			map.put(sct.getItem().getItemId(), sc);  //重新添加到购物车
		}else{
			map.put(sct.getItem().getItemId(), sct);
		}
	}
	
	//清除购物车
	public void chear(){
		map.clear();  //执行集合清除的方法
	}
	
	//删除购物车条目（根据商品id）
	public void close(Integer itemId){
		map.remove(itemId);
	}
	
	//查看购物车条目信息
	public Collection<ShopCartitem> getCartitem(){
		return map.values();   //直接返回map集合的values值
	}
	
	//修改购物车条目信息
	public void updateCart(Integer itemId,int num ){
		ShopCartitem sc=map.get(itemId);  //获得条目信息
		sc.setNum(num);  //重新设置数量
	}
}