package com.java.design_model.zhuangshi;

/**
 * Created by 1 on 2017/8/6.
 */
public class FoodOrder implements Order {
    private String name;
    public FoodOrder(String name) {
        this.name = name;
    }
    @Override
    public void printInfo() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        FoodOrder food = new FoodOrder("中华火腿");
        AfterFoodDecorator ad = new AfterFoodDecorator(food);
        PreviousFoodDecorator pd = new PreviousFoodDecorator(ad);
        pd.printInfo();
    }
}
