package dc;

public class ProductBuilder extends Builder {

	Product product;

	@Override
	public Product buildPart() {
		product = new Product();// TODO Auto-generated method stub
		return getResult();
	}

	public Product getResult() {
		return this.product;
	}

}
