package org.cuber.service;

import org.cuber.database.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by cuber on 2016/1/29.
 */
@Service
public class MybatisDBService {
    @Autowired
    private BaseMapper baseMapper;

    public Timestamp getTime(){
        return baseMapper.getDbTimestamp();
    }
}