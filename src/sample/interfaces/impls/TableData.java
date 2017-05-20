package sample.interfaces.impls;
import sample.object.Smeta;

/**
 * Created by karpik on 17.05.2017.
 */
public interface TableData {
    void add(Smeta smeta);

    // внести измененные значения (подтвердить измененные данные)
    void update(Smeta smeta);

    // удалить запись
    void delete(Smeta smeta);

}
