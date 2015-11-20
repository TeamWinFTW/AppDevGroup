package db;

import ie.james.Exhibit;

import java.util.List;

/**
 * Created by User on 05/11/2015.
 */
public interface DAO {
    void save(Exhibit exhibit);
    void update(Exhibit exhibit);
    void delete(String id);
    Exhibit findExhibitById(String id);

}
