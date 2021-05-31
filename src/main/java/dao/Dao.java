package dao;

public interface Dao<Entity, Key> {
    boolean create(Entity model);
    Entity read(Key key);
    boolean update (Entity model);
    boolean delete (Entity model);
}