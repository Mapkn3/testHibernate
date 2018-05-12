package utils;

import entities.PrettyEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EntityDao<E extends PrettyEntity> {
    private Session session;

    public EntityDao(Session session) {
        this.session = session;
    }

    public List<E> getAll(Class<E> entityClass) {
        return session.createCriteria(entityClass).list();
    }

    public boolean createEntity(E entity) {
        if (session.get(entity.getClass(), entity.primaryKey()) != null) {
            return false;
        }
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        return true;
    }

    public E readEntity(Class<E> entityClass, Long primaryKey) {
        return session.get(entityClass, primaryKey);
    }

    public boolean updateEntity(E entity) {
        if (session.get(entity.getClass(), entity.primaryKey()) == null) {
            return false;
        }
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        return true;
    }

    public boolean deleteEntity(E entity) {
        if (session.get(entity.getClass(), entity.primaryKey()) == null) {
            return false;
        }
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        return true;
    }
}
