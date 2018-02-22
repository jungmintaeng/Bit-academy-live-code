package chapter03;


public class GoodsApp {
	public static void main(String[] args) {
		Goods camera = null;
		for(int i = 0 ; i < 10; i++) {
			camera = new Goods();
		}
		
		//기본 생성자로 생성 후 setter를 통해 수동으로 setting
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountStock(30);
		camera.setCountSold(50);
		camera.showInfo();
		
		Goods good = new Goods("canon", 500000, 10, 20);//생성자 Overloading
		good.showInfo();
		
		System.out.println("생성자 호출 횟수 : " + Goods.countOfGoods);
		System.out.println("할인된 가격 : " + camera.calcDiscountPrice(0.8));
	}
}
