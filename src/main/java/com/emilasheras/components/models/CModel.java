package com.emilasheras.components.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.transaction.Transactional;
import jakarta.persistence.Id;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.emilasheras.components.util.EntityManagerUtil;

@MappedSuperclass
public abstract class CModel implements CModelInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Transactional
    public void save() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(this);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    @Transactional
    public void update() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(this);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    @Transactional
    public void delete() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(this) ? this : em.merge(this));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}