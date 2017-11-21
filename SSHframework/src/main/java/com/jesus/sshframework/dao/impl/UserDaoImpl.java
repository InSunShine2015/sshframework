package com.jesus.sshframework.dao.impl;

import org.springframework.stereotype.Repository;

import com.jesus.sshframework.dao.IUserDao;
import com.jesus.sshframework.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements IUserDao{

	public boolean isExistByUsername(String username) {
		String hql = "from User where username = ? ";
		User admin = (User) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}
	
	//判断
	@Override
	public String save(User user) {
		return super.save(user);	
	}

    @Override
    public User findByNamePwd(String userName, String password) {
        String hql = "from User user where user.username = ? and user.password = ? ";
        User user = (User) getSession().createQuery(hql).
                                            setParameter(0, userName).
                                            setParameter(1, password).
                                            uniqueResult();
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        String hql = "from User where username = ? ";
        User admin = (User) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
        return admin;
    }

}
