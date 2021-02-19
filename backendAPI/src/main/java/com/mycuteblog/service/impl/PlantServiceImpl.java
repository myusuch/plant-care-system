package com.mycuteblog.service.impl;

import com.mycuteblog.dao.PlantDao;
import com.mycuteblog.model.Plant;
import com.mycuteblog.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantDao plantDao;

    @Override
    public void create(Plant plant) {
        plantDao.create(plant);
    }

    @Override
    public void update(Plant plant) {
        plantDao.update(plant);
    }

    @Override
    public Plant getApiRequestById(long id) {
        return plantDao.getApiRequestById(id);
    }

    @Override
    public List<Plant> findAllApiRequestWithJpql() {
        return plantDao.findAllApiRequestWithJpql();
    }




}
