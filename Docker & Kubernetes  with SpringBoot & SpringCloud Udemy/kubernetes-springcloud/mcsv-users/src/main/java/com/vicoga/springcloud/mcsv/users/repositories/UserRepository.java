package com.vicoga.springcloud.mcsv.users.repositories;

import com.vicoga.springcloud.mcsv.users.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
