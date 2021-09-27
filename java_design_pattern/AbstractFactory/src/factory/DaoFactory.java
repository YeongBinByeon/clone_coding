package factory;

import domain.product.dao.ProductDao;
import domain.userInfo.dao.UserInfoDao;

public interface DaoFactory {
	public UserInfoDao createUserInfoDao();
	public ProductDao createProductDao();
}
