package factory;

import domain.product.dao.ProductDao;
import domain.product.dao.oracle.ProductOracleDao;
import domain.userInfo.dao.UserInfoDao;
import domain.userInfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory{

	@Override
	public UserInfoDao createUserInfoDao() {
		return new UserInfoOracleDao();
	}

	@Override
	public ProductDao createProductDao() {
		return new ProductOracleDao();
	}

}
