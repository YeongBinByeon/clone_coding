package web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import domain.product.Product;
import domain.product.dao.ProductDao;
import domain.userInfo.UserInfo;
import domain.userInfo.dao.UserInfoDao;
import factory.DaoFactory;
import factory.MySqlDaoFactory;
import factory.OracleDaoFactory;

public class WebClient {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("db.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String dbType = prop.getProperty("DBTYPE");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPassword("12345");
		userInfo.setUserName("ÀÌ¼ø½Å");
		
		Product product = new Product();
		product.setProductId("0011AA");
		product.setProductName("TV");
		
		DaoFactory daoFactory = null;
		
		if(dbType.equals("MYSQL")) {
			daoFactory = new MySqlDaoFactory();
		}
		else if(dbType.equals("ORACLE")) {
			daoFactory = new OracleDaoFactory();
		}
		else {
			System.out.println("error");
		}
		
		UserInfoDao userInfoDao = daoFactory.createUserInfoDao();
		System.out.println("====UserInfo TRANSACTION====");
		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInfo(userInfo);
		
		
		System.out.println("====Product TRANSACTION====");
		ProductDao productDao = daoFactory.createProductDao();
		productDao.insertProduct(product);
		productDao.updateProduct(product);
		productDao.deleteProduct(product);
		
		
	}

}
