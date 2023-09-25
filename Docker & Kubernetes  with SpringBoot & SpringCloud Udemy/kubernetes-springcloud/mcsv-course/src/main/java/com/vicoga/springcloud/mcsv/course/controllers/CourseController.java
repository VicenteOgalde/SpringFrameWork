package com.vicoga.springcloud.mcsv.course.controllers;

import com.vicoga.springcloud.mcsv.course.entity.Course;
import com.vicoga.springcloud.mcsv.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> list(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Course> o=service.findById(id);
        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
    }

}
