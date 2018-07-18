package com.jfz.pageHelper.mapper;

import com.jfz.pageHelper.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/15 10:24
 */
@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<User> getAll();

    @SelectProvider(type=UserDaoSelectProvider.class,method = "getCount")
    Long getCount(User user);

    @SelectProvider(type=UserDaoSelectProvider.class,method = "getPageList")
    List<User> getPageList(User user);

    class UserDaoSelectProvider {
        public String getPageList(User user){
            String sql = "SELECT * FROM sys_user";
            sql += " where 1=1";
            if(StringUtils.isNotBlank(user.getMobile())){
                sql += " and mobile regexp '"+ user.getMobile()+"'";
            }
            if(StringUtils.isNotBlank(user.getFullname())){
                sql += " and fullname regexp '"+ user.getFullname()+"'";
            }
            return sql;
        }

        public String getCount(User user){
            String sql = "SELECT count(1) FROM sys_user";
            sql += " where 1=1";
            if(StringUtils.isNotBlank(user.getMobile())){
                sql += " and mobile regexp '"+ user.getMobile()+"'";
            }
            if(StringUtils.isNotBlank(user.getFullname())){
                sql += " and fullname regexp '"+ user.getFullname()+"'";
            }
            return sql;
        }
    }
}
