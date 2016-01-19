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
   
	@Autowired			//底层dao接口引入
	private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {				//查询业务 ,对查询接口[重写]
        return this.userMapper.selectByPrimaryKey(userId);
    }
    
    @Override
    public void deleteById(int userId) {				//删除业务 ,对删除接口[重写]
        this.userMapper.deleteByPrimaryKey(userId);
    }
    
    @Override
    public void insertOne(User userOne) {				//插入业务 ,对插入接口[重写]
        this.userMapper.insert(userOne);
    }

    @Override
    public void updateById(User userOne) {				//插入业务 ,对插入接口[重写]
        this.userMapper.updateByPrimaryKeySelective(userOne);
    }
}
