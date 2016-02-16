package org.cuber.service;

import org.cuber.database.entity.IdInstance;
import org.cuber.database.entity.Resource;
import org.cuber.database.mapper.BaseMapper;
import org.cuber.database.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by cuber on 2016/1/29.
 */
@Service
public class MybatisDBService {
    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private ResourceMapper resourceMapper;



    public Timestamp getTime(){
        return baseMapper.getDbTimestamp();
    }

    public String getId(String idTyppe){
        IdInstance idInstance = new IdInstance();
        idInstance.setIdType(idTyppe);
        baseMapper.getId(idInstance);
        return idInstance.getId();
    }

    public List<Resource> getAllResource(){
        try{
            return resourceMapper.getAllResources();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
