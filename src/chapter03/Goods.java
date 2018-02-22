package chapter03;

public class Goods {
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public static int countOfGoods = 0;
	
	/**
	 * Constructor
	 */
	
	//basic constructor
	public Goods() {
		countOfGoods++;
	}
	
	//생성자 OverLoading
	public Goods(String name, int price, int countStock, int countSold) {
		countOfGoods++;
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	
	/**
	 * getter-setter
	 */
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCountStock() {
		return countStock;
	}
	
	public int getCountSold() {
		return countSold;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		if(price < 0)
			this.price = 0;
		else
			this.price = price;
	}
	
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	/**
	 * methods
	 */
	
	public void showInfo() {
		System.out.println(this.toString());
	}
	
	public int calcDiscountPrice(double rate) {
		return (int)(price * rate);
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", countStock=" + countStock + ", countSold=" + countSold
				+ "]";
	}
}
