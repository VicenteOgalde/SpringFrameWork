package com.vicoga.springcloud.mcsv.course.repository;

import com.vicoga.springcloud.mcsv.course.models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Modifying
    @Query("delete from CourseUser cu where cu.userId=?1")
    void deleteCourseUserById(Long id);
}
