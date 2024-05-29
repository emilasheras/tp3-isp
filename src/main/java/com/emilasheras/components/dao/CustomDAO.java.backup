package com.emilasheras.components.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.emilasheras.components.models.CModel;

public class CustomDAO<T extends CModel> implements CustomDAOInterface<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(T model) {
        entityManager.persist(model);
    }

    @Transactional
    @Override
    public void update(T model) {
        entityManager.merge(model);
    }

    @Transactional
    @Override
    public void delete(T model) {
        entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));
    }
}
