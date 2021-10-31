package composite;

public abstract class ProductCategory {
	int id;
	String name;
	int price;
	
	public ProductCategory(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public abstract void addProductCategory(ProductCategory	productCategory);
	public abstract void removeProductCategory(ProductCategory	productCategory);
	public abstract int getCount();
	public abstract int getPrice();
	public abstract String getName();
	public abstract int getId();
	
}
