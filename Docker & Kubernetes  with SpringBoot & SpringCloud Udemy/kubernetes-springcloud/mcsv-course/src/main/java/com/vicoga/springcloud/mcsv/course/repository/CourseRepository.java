package com.vicoga.springcloud.mcsv.course.repository;

import com.vicoga.springcloud.mcsv.course.models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
