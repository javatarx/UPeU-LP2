package edu.upeu.school.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    List<T> getAll(Class<T> typeClass);

    List<T> getAllRestrictionNE(Class<T> typeClass, String columnaRestriccion, String valorRestriccion);

    List<T> getAllRestrictionEQ(Class<T> typeClass, String columnaRestriccion, String valorRestriccion);

    List<T> getAllOrdered(Class<T> typeClass, String columnaOrden);

    List<T> getAllOrderedDesc(Class<T> typeClass, String columnaOrden);

    List<T> getAllOrderedRestrictionNE(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion);

    List<T> getAllOrderedRestrictionEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion);

    T findByPK(Class<T> typeClass, PK id);

    T loadByPK(Class<T> typeClass, PK id);

    public T findByColumn(Class<T> typeClass, String columna, String valor);

    public T findByTwoColumnBoolean(Class<T> typeClass, String columna, String valor, String columna2, boolean valor2);

    public T findByTwoColumn(Class<T> typeClass, String columna, String valor, String columna1, String valor1);

    void update(T object);

    void remove(T object);

    void insert(T object);

    public void DeleteSession(Class<T> typeClass);

    List<T> getPaginated(Class<T> typeClass, int startPosition, int maxResult);

    List<T> getOrderedPaginated(Class<T> typeClass, int startPosition, int maxResult, String order, int dir);

    public List<T> getAllOrderedRestrictionTwoEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion, String columnaRestriccion1, String valorRestriccion1);

    public List<T> getAllOrderedRestrictionThreeEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion, String columnaRestriccion1, String valorRestriccion1, String columnaRestriccion3, boolean valorRestriccion3);

    T findByColumnLike(Class<T> typeClass, String columna, String valor);

    List<T> getAllOrderedRestrictionEQDesc(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion);

    T findByTwoColumnEQandNe(Class<T> typeClass, String columna, String valor, String columna1, String valor1);

    public List<T> getAllOrderedRestrictionTwoBooleanEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion, String valorRestriccion, String columnaRestriccion1, Boolean valorRestriccion1);

    T findByTwoColumnLike(Class<T> typeClass, String columna01, String valor01, String columna02, String valor02);
}
