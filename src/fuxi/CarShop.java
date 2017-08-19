package fuxi;

/**
 * 汽车销售4S店
 * @author Administrator
 *
 */
public class CarShop {
	/**
	 * 售车收入
	 */
	private int money = 0;

	/**
	 * 卖出一部车
	 * @param car
	 */
	public void sellCar(Car car){
		System.out.println("车型："+car.getName()+",单价:"+car.getPrice());
		//售车收入累计
		money += car.getPrice();
	}

	/**
	 * 售车总收入
	 * @return
	 */
	public int getMoney(){
		return money;
	}

}
