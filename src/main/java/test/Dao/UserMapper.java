package test.Dao;

import org.springframework.stereotype.Repository;

import test.model.User;

/**
 * (存放spring与mybatis连接接口)
 * @author tony
 *
 */
@Repository
public interface UserMapper {	
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}