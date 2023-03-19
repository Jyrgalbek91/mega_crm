package dao;

import model.Group;

public interface GroupDao {
    void save(Group group);
    Group[] findAll();
}
