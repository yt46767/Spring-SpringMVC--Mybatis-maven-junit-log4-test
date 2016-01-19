package test.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import test.model.User;

/**
 * （service接口）
 * @author tony
 *
 */
@Repository
public interface  UserServiceImp {		//UserService接口
	public User getUserById(int userId);
	
}
