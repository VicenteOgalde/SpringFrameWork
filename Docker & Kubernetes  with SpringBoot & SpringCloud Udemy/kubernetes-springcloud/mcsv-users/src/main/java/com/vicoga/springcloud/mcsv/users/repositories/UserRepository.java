package com.vicoga.springcloud.mcsv.users.repositories;

import com.vicoga.springcloud.mcsv.users.models.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
