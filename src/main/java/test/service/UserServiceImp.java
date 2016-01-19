package test.service;

import org.springframework.stereotype.Repository;

import test.model.User;

/**
 * （service接口）
 * @author tony
 *
 */
@Repository
public interface UserServiceImp {			//接口定义：初始化函数，供业务类重写
	
	public User getUserById(int userId);	//查询接口
	
	public void deleteById(int userId);		//删除接口
	
	public void insertOne(User userId);		//插入接口
	
	public void updateById(User userId);	//修改接口
}
