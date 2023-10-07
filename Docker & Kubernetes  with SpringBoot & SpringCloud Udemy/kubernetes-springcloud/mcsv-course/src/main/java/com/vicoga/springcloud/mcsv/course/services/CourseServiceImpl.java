package com.vicoga.springcloud.mcsv.course.services;

import com.vicoga.springcloud.mcsv.course.models.entity.Course;
import com.vicoga.springcloud.mcsv.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;
    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Course save(Course course) {
        return repository.save(course);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
