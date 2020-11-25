package com.kgc.realEstateInformationQuery.service;

import com.kgc.realEstateInformationQuery.pojo.Users;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-21 14:22
 */
public interface UsersService {
   Users selectUsers(String cardid);
   int addUsers(String cardid,String name,String password);
   List<Users> getUsersList(String name);

}
