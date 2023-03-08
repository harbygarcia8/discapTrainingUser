package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.Discapacity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscapacityRepository extends CrudRepository<Discapacity, Integer> {


}
