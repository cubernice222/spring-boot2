package org.cuber.database.mapper;

import org.apache.ibatis.annotations.Select;
import org.cuber.database.entity.Resouce;

import java.util.List;

/**
 * Created by cuber on 2016/2/15.
 */
public interface ResouceMapper extends BaseMapper{
    @Select("")
    List<Resouce> getAllResouce();
}
