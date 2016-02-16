package org.cuber.database.mapper;


import org.cuber.database.entity.Resource;

import java.util.List;

/**
 * Created by cuber on 2016/2/15.
 */
public interface ResourceMapper extends BaseMapper{
    List<Resource> getAllResources();
}
