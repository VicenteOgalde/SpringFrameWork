package com.vicoga.springcloud.mcsv.course.clients;

import com.vicoga.springcloud.mcsv.course.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mcsv-users", url = "localhost:8001")
public interface UserClientRest {
    @GetMapping("/{id}")
    public User details(@PathVariable Long id);
    @PostMapping("/")
    public User create(@RequestBody User user);


}
