package test.service;

import javax.annotation.Resource;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;  

import org.springframework.transaction.annotation.Transactional;

import test.Dao.UserMapper;
import test.model.User;

/**
 * （service接口的实现）
 * @author tony
 *
 */
//@Transactional
@Service("UserService")
public class UserService implements UserServiceImp {  	//UserServiceImpl实现类
   
	@Autowired
	private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

}
