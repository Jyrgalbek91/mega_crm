package dao;

import model.Course;

public interface CourseDao {
    void save(Course course);
    Course[] findAll();
}
