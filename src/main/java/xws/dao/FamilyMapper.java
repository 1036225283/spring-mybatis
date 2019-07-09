package xws.dao;

import xws.entity.Family;

public interface FamilyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Family record);

    int insertSelective(Family record);

    Family selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Family record);

    int updateByPrimaryKey(Family record);
}