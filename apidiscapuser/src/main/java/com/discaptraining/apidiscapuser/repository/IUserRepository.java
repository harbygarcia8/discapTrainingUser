package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserRepository extends CrudRepository<User, Integer> {

    User findByPersonID(int cedula);

    List<User> getUserByGender(boolean gender);

}
