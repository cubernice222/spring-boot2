package org.cuber.database.mapper;

import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

/**
 * Created by cuber on 2016/1/29.
 */
public interface BaseMapper {
    @Select("Select sysdate()")
    Timestamp getDbTimestamp();
}
