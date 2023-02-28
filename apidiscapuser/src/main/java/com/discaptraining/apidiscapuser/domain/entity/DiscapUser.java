package com.discaptraining.apidiscapuser.domain.entity;

import com.discaptraining.apidiscapuser.domain.enums.PersonGender;
import com.discaptraining.apidiscapuser.domain.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "discapUser")
public class DiscapUser {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Getter
    @Setter
    @Column(name="documentType")
    private String documentType;

    @Getter
    @Setter
    @Column(name = "document")
    private Integer personID;


    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "lastName")
    private String surname;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private PersonGender gender;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name="email")
    private String email;

    @Getter
    @Setter
    @Column(name = "registerType")
    @Enumerated(EnumType.STRING)
    private UserType registerType;

    @ManyToOne
    @JoinColumn(name = "id_discapacity", insertable = false, updatable = false)
    private Discapacity discapacity;

    @Getter
    @Setter
    @Column(name="password")
    private String password;
    @Getter
    @Setter
    @Column(name = "active")
    private boolean active;

}
