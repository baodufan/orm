package cn.ordering.order.dao;
/**
 * 优惠券接口类
 * @author baodu
 *
 */

import cn.ordering.order.bean.Discount;
public interface DiscountDao {
          //根据id查看优惠券
	public Discount listDiscount(Integer discountId);
}
