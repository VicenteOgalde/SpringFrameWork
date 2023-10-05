package com.vicoga.springcloud.mcsv.course.controllers;

import com.vicoga.springcloud.mcsv.course.entity.Course;
import com.vicoga.springcloud.mcsv.course.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Course course, BindingResult result){
        if (result.hasErrors()) {
            return validation(result);
        }
        Course course1= service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course1);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Course course,BindingResult result,@PathVariable Long id){
        if (result.hasErrors()){
            return validation(result);
        }

        Optional<Course> optionalCourse=service.findById(id);
        if (optionalCourse.isPresent()){
            optionalCourse.get().setName(course.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(optionalCourse.get()));

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
    private static ResponseEntity<Map<String, String>> validation(BindingResult result) {
        Map<String,String>errors= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errors.put(err.getField(),"The field ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
