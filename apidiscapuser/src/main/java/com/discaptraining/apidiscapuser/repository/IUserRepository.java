package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepository extends CrudRepository<DiscapUser, Integer> {

    List<DiscapUser> findByPersonID(int cedula);
    List<DiscapUser> finDiscapUserList();

    List<DiscapUser> getUserByGender(boolean gender);

}
