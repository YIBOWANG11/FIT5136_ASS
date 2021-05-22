package code.repo;

import code.accessor.Accessor;
import code.entity.CmsEntity;
import code.entity.User;

import java.util.List;

public interface Repository<E> {

    List<E> findAll();

    void addOne(E entity);

    Integer generateMaxId();

    void retrieveAll();
}
