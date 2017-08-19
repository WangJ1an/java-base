package com.java.design_model.clone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/8/6.
 */
public class Warehouse implements Cloneable {
    private String name;
    private List<Goods> goodsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }


    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    //深拷贝，将被拷贝对象里引用的每个对象也new一个新的出来添加进去。
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Warehouse warehouse = (Warehouse) super.clone();
        warehouse.setName(this.name);
        List<Goods> list = new ArrayList<>();

        for (Goods g : this.goodsList) {
            Goods goods = (Goods) g.clone();
            list.add(goods);
        }

        warehouse.setGoodsList(list);
        return warehouse;
    }
}
