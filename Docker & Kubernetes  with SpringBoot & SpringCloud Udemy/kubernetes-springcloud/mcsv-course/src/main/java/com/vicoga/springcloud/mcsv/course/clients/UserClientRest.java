package com.vicoga.springcloud.mcsv.course.clients;

import com.vicoga.springcloud.mcsv.course.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "mcsv-users", url = "localhost:8001")
public interface UserClientRest {
    @GetMapping("/{id}")
    public User details(@PathVariable Long id);
    @PostMapping("/")
    public User create(@RequestBody User user);
    @GetMapping("/course-users")
    public List<User> getUsersByCourse(@RequestParam Iterable<Long> ids);



    }
