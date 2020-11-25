package com.kgc.realEstateInformationQuery.service;

import com.kgc.realEstateInformationQuery.mapper.UsersMapper;
import com.kgc.realEstateInformationQuery.pojo.Users;
import com.kgc.realEstateInformationQuery.pojo.UsersExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-21 14:22
 */
@Transactional
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public Users selectUsers(String cardid) {
        Users users = usersMapper.selectByPrimaryKey(cardid);
        return users;
    }

    @Override
    public int addUsers(String cardid, String name, String password) {
        String str=cardid.toString().substring(16,17);
        Integer gender=null;
        if(str.equals("1")||str.equals("3")||str.equals("5")||str.equals("7")||str.equals("9")){
            gender=0;
        }else if(str.equals("2")||str.equals("4")||str.equals("6")||str.equals("8")||str.equals("0")){
            gender=1;
        }
        Users users=new Users(cardid,name,gender,new Date(),password,1);
        int i = usersMapper.insertSelective(users);
        return i;
    }

    @Override
    public List<Users> getUsersList(String name) {
        UsersExample usersExample=new UsersExample();
        if(name!=null){
            UsersExample.Criteria criteria=usersExample.createCriteria();
            criteria.andNameLike(name);
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users;
    }
}
