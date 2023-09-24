package com.vicoga.springcloud.mcsv.course.controllers;

import com.vicoga.springcloud.mcsv.course.entity.Course;
import com.vicoga.springcloud.mcsv.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> list(){
        return ResponseEntity.ok(service.findAll());
    }

}
