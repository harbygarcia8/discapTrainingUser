package com.discaptraining.apidiscapuser.repository;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<DiscapUser, Integer> {
    @Query(value = "select * from schema_discap.discap_user where document = ?1", nativeQuery = true)
    List<DiscapUser> findDiscapUser(int cedula);
    @Query(value = "select d.id as id, d.document_type as document_type,d.document as document , d.name as name, d.last_name as last_name, d.gender as gender, " +
            "d.phone as phone,d.email as email, d.register_type as register_type, d.password as password, d.active as active FROM schema_discap.discap_user d", nativeQuery = true)
    List<DiscapUser> findDiscapUserList();

    @Query(value = "select * from schema_discap.discap_user where email = ?", nativeQuery = true)
    Optional<DiscapUser> findDiscapUserByEmail(String email);

}
