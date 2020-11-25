package com.kgc.realEstateInformationQuery.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.realEstateInformationQuery.mapper.RealEstateMapper;
import com.kgc.realEstateInformationQuery.pojo.RealEstate;
import com.kgc.realEstateInformationQuery.pojo.RealEstateExample;
import com.kgc.realEstateInformationQuery.pojo.Users;
import com.kgc.realEstateInformationQuery.pojo.UsersExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-21 14:25
 */
@Transactional
@Service
public class RealEstateServiceImpl implements RealEstateService {
    @Resource
    RealEstateMapper realEstateMapper;


    @Override
    public PageInfo<RealEstate> selectUsers(String cardid, Integer pageNum, Integer pageSize) {
        //设置当前页和页容量
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("buildTime");
        RealEstateExample re=new RealEstateExample();
        RealEstateExample.Criteria criteria=re.createCriteria();
        criteria.andCardidLike("%"+cardid+"%");
        List<RealEstate> users = realEstateMapper.selectByExample(re);
        PageInfo<RealEstate> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }
}
