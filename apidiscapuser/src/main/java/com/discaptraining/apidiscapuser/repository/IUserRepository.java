package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<DiscapUser, Integer> {

    DiscapUser findByPersonId(int personId);
    DiscapUser findById(int id);
    DiscapUser findByEmail(String email);

    List<DiscapUser> findAllByActive(boolean isActive);

}
