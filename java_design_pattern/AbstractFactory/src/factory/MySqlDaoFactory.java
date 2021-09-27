package factory;

import domain.product.dao.ProductDao;
import domain.product.dao.mysql.ProductMySqlDao;
import domain.userInfo.dao.UserInfoDao;
import domain.userInfo.dao.mysql.UserInfoMySqlDao;

public class MySqlDaoFactory implements DaoFactory{

	@Override
	public UserInfoDao createUserInfoDao() {
		return new UserInfoMySqlDao();
	}

	@Override
	public ProductDao createProductDao() {
		// TODO Auto-generated method stub
		return new ProductMySqlDao();
	}

}
