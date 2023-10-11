package com.vicoga.springcloud.mcsv.users.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mcsv-course" ,url = "localhost:8002")
public interface CourseClientRest {

    @DeleteMapping("/delete-course-user/{id}")
    void deleteCourseUserById(@PathVariable Long id);

    }
