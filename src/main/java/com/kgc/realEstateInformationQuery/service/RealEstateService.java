package com.kgc.realEstateInformationQuery.service;

import com.github.pagehelper.PageInfo;
import com.kgc.realEstateInformationQuery.pojo.RealEstate;


/**
 * @author shkstart
 * @create 2020-11-21 14:25
 */
public interface RealEstateService {
    public PageInfo<RealEstate> selectUsers(String cardid, Integer pageNum, Integer pageSize);

}
