package fuxi;

/**
 * 宝马
 * @author Administrator
 *
 */
public class BMW implements Car {

	@Override
	public String getName() {
		return "BMW";
	}

	@Override
	public int getPrice() {
		return 300000;
	}

}
