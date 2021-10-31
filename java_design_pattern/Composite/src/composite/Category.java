package composite;

import java.util.ArrayList;

public class Category extends ProductCategory{

	ArrayList<ProductCategory> list;
	
	
	public Category(int id, String name, int price) {
		super(id, name, price);
		list = new ArrayList<ProductCategory>();
	}

	@Override
	public void addProductCategory(ProductCategory productCategory) {
		list.add(productCategory);
	}

	@Override
	public void removeProductCategory(ProductCategory productCategory) {
		for(ProductCategory temp : list) {
			if(temp.getId() == productCategory.getId()) {
				list.remove(temp);
				return;
			}
		}
		System.out.println("��ǰ�� �����ϴ�.");
	}

	@Override
	public int getCount() {
		int count = 0;
		
		for(ProductCategory temp : list) {
			count += temp.getCount();
		}
		
		return count;
	}

	@Override
	public int getPrice() {
		int price = 0;
		
		for(ProductCategory temp : list) {
			price += temp.getPrice();
		}
		
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}

}
