package domain.product.dao;

import domain.product.Product;

public interface ProductDao {
	void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
