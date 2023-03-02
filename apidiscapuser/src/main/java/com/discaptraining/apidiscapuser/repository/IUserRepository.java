package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository extends CrudRepository<DiscapUser, Integer> {
    @Query(value = "select * from discap_user where document = '?'", nativeQuery = true)
    List<DiscapUser> findDiscapUsers(int cedula);
    @Query(value = "select id, active, document_type, email, gender, name, password, document, phone, register_type, last_name, id_discapacity from discap_user", nativeQuery = true)
    List<DiscapUser> findDiscapUserList();


}
