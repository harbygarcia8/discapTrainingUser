package com.discaptraining.apidiscapuser.domain.entity;

import com.discaptraining.apidiscapuser.domain.enums.PersonGender;
import com.discaptraining.apidiscapuser.domain.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "discap_user")
@Getter
@Setter
public class DiscapUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "document_type")
    private String documentType;


    @Column(name = "document")
    private Integer personID;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Enumerated(EnumType.STRING)
    private PersonGender gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "register_type")
    @Enumerated(EnumType.STRING)
    private UserType registerType;

    @ManyToMany
    @JoinColumn(name = "discapacitys", insertable = false, updatable = false)
    private List<Discapacity> discapacitys;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PersonGender getGender() {
        return gender;
    }

    public void setGender(PersonGender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getRegisterType() {
        return registerType;
    }

    public void setRegisterType(UserType registerType) {
        this.registerType = registerType;
    }

    public List<Discapacity> getDiscapacitys() {
        return discapacitys;
    }

    public void setDiscapacitys(List<Discapacity> discapacitys) {
        this.discapacitys = discapacitys;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
