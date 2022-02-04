package com.imooc.spring.ioc.entity;

/**
 * @author liuliang
 * 2022/1/24
 */
public class Computer {
    private String title;
    private String type;
    private String sn;
    private Float price;

    @Override
    public String toString() {
        return "Computer{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", sn='" + sn + '\'' +
                ", price=" + price +
                '}';
    }

    public Computer() {
    }

    public Computer(String title, String type, String sn, Float price) {
        this.title = title;
        this.type = type;
        this.sn = sn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
