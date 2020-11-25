package com.kgc.realEstateInformationQuery.mapper;

import com.kgc.realEstateInformationQuery.pojo.RealEstate;
import com.kgc.realEstateInformationQuery.pojo.RealEstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealEstateMapper {
    int countByExample(RealEstateExample example);

    int deleteByExample(RealEstateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RealEstate record);

    int insertSelective(RealEstate record);

    List<RealEstate> selectByExample(RealEstateExample example);

    RealEstate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RealEstate record, @Param("example") RealEstateExample example);

    int updateByExample(@Param("record") RealEstate record, @Param("example") RealEstateExample example);

    int updateByPrimaryKeySelective(RealEstate record);

    int updateByPrimaryKey(RealEstate record);
}