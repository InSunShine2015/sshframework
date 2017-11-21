package com.jesus.sshframework.service;

import com.jesus.sshframework.model.User;

public interface IUserService extends IBaseService<User, String>{

    User findUser(String userName, String password);

    boolean findUserByName(String username);

    User findEntityUserByName(String username);

    void update(User userdb);

	
}
