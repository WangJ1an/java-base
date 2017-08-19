package com.java.design_model.clone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/8/6.
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("123");
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("方便面",4.5));
        list.add(new Goods("哇哈哈",2));
        warehouse.setGoodsList(list);

        Warehouse warehouseByClone = (Warehouse) warehouse.clone();
        System.out.println(warehouse.getName());
        list = warehouse.getGoodsList();
        for (Goods g :
                list) {
            System.out.println(g.getName()+"----"+g.getPrice());
        }
        System.out.println("clone出的对象=============");
        warehouseByClone.setName("456");
        System.out.println(warehouseByClone.getName());
        list = warehouseByClone.getGoodsList();
        for (Goods g :
                list) {
            System.out.println(g.getName()+"----"+g.getPrice());
        }
    }
}
