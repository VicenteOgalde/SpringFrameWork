package com.vicoga.springcloud.mcsv.course.services;

import com.vicoga.springcloud.mcsv.course.models.User;
import com.vicoga.springcloud.mcsv.course.models.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course save(Course course);
    void deleteById(Long id);


    Optional<User> assignUser(User user,Long courseId);
    Optional<User> createUser(User user, Long courseId);
    Optional<User> unAssignUser(User user,Long courseId);
}
