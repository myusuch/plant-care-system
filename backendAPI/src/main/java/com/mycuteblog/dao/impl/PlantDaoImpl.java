package com.mycuteblog.dao.impl;

import com.mycuteblog.dao.PlantDao;
import com.mycuteblog.model.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlantDaoImpl implements PlantDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Plant plant) {
        entityManager.persist(plant);
    }

    @Override
    public void update(Plant plant) {
        entityManager.merge(plant);
    }

    @Override
    public Plant getApiRequestById(long id) {
        return entityManager.find(Plant.class, id);
    }

    @Override
    public void delete(long id) {
        Plant plant = getApiRequestById(id);
        if (plant != null) {
            entityManager.remove(plant);
        }
    }

    @Override
    public List<Plant> findAllApiRequestWithJpql() {
        List <Plant> plantList = entityManager.createQuery("SELECT a FROM Plant a", Plant.class).getResultList();
        return plantList;
    }
}

