package com.discaptraining.apidiscapuser.domain.entity;

import com.discaptraining.apidiscapuser.domain.enums.Discapacities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

    @Entity
    @Table(name = "Discapacity")
    public class Discapacity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_discapacity")
    private Integer id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "discapacity")
    private Discapacities discapacity;


    @OneToMany(mappedBy = "discapacity")
    private List<User> user;


}
