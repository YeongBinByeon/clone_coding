package domain.userInfo.dao;

import domain.userInfo.UserInfo;

public interface UserInfoDao {
	void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(UserInfo userInfo);
}
