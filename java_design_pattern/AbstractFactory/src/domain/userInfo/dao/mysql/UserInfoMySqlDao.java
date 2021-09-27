package domain.userInfo.dao.mysql;

import domain.userInfo.UserInfo;
import domain.userInfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MySQL DB userId =" + userInfo.getUserId() );
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MySQL DB userId =" + userInfo.getUserId() );
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete from MySQL DB userId =" + userInfo.getUserId() );
	}
	

}
