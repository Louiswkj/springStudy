package com.imooc.spring.ioc.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuliang
 * 2022/1/24
 */
public class Company {
   private List<String> rooms;

   private Map<String,Computer> computers;

   private Properties info;

    @Override
    public String toString() {
        return "Company{" +
                "rooms=" + rooms +
                ", computers=" + computers +
                ", info=" + info +
                '}';
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public Map<String, Computer> getComputers() {
        return computers;
    }

    public void setComputers(Map<String, Computer> computers) {
        this.computers = computers;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }
}
