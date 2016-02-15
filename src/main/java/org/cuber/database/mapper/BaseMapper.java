package org.cuber.database.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.cuber.database.entity.IdInstance;

import java.sql.Timestamp;

/**
 * Created by cuber on 2016/1/29.
 */
public interface BaseMapper {
    @Select("Select sysdate()")
    Timestamp getDbTimestamp();
    @Select("call P_GETID(#{idType, mode=IN, jdbcType=VARCHAR}, #{id, mode=OUT, jdbcType=VARCHAR})")
    @Options(statementType = StatementType.CALLABLE)
    void getId(IdInstance idInstance);
}
