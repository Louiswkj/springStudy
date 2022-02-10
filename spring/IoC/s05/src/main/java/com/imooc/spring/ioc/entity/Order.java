package com.imooc.spring.ioc.entity;

/**
 * @author liuliang
 * 2022/1/25
 */
public class Order {
    private Float price;
    private Integer quantity;
    private Float total;

    public Order() {
        System.out.println("创建Order对象：" + this);
    }

    public void init() {
        System.out.println("执行init方法");
        total = price * quantity;
    }

    public void pay() {
        System.out.println("订单金额：" + total);
    }

    public Float getPrice() {
        System.out.println("获取price：" + quantity);
        return price;
    }

    public void setPrice(Float price) {
        System.out.println("设置price：" + price);
        this.price = price;
    }

    public Integer getQuantity() {
        System.out.println("获取quantity：" + quantity);
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        System.out.println("设置quantity：" + quantity);
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void destroy(){
        System.out.println("释放与订单对象相关的资源");
    }
}
