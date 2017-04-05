package com.java.base.meiju;

/**
 * Created by 1 on 2017/1/17.
 */
public enum Sex {
    MAN(0,"男"),WOMAN(1,"女");

    private int id;

    private String name;

    Sex(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public static void main(String []args){
        Sex sex1 = Sex.MAN;
        Sex sex2 = Sex.MAN;

        sex1.setName("王键");

        System.out.println(sex2.getName());

        sex2.setName("meiju");

        System.out.println(sex2.getName());

        System.out.println(sex1.getName());

        System.out.println(sex1 == sex2);
    }
}
