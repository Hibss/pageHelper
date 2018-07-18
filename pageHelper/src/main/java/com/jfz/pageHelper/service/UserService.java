package com.jfz.pageHelper.service;

import com.github.pagehelper.PageHelper;
import com.jfz.pageHelper.mapper.PageInfo.Page;
import com.jfz.pageHelper.mapper.UserMapper;
import com.jfz.pageHelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/21 15:28
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(Page page){
        PageHelper.startPage(page.getPage(),page.getRows(),page.getOrderBy());
        return userMapper.getAll();
    }
}
