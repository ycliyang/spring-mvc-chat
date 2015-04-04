package com.ly.web.service;


import com.ly.web.db.dao.UsersDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("userService")
public class UserService {

	@Resource
	private UsersDAO userDao;

	@Transactional
	public int userCount(){
		return userDao.getAllUser().size();
	}

	public UsersDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UsersDAO userDao) {
		this.userDao = userDao;
	}

}
