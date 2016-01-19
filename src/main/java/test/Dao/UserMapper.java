package test.Dao;

import org.springframework.stereotype.Repository;

import test.model.User;

/**
 * (存放spring与mybatis连接接口)
 * @author tony
 *
 */
@Repository
public interface UserMapper {	//底层数据链路
	
    int deleteByPrimaryKey(Integer id);				//删除语句：只能删除一条语句	[测试通过]

    int insert(User record);						//插入语句：只能插入一条语句	[测试通过]

    int insertSelective(User record);				//插入语句：只能插入一条语句	[测试通过]

    User selectByPrimaryKey(Integer id);			//查询语句：只能查询一条语句	[测试通过]

    int updateByPrimaryKeySelective(User record);	//修改语句：只能查询一条语句	[测试通过]

    int updateByPrimaryKey(User record);			//修改语句：只能查询一条语句	[测试通过]
}