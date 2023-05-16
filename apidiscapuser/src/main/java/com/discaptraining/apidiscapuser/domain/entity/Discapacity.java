package com.discaptraining.apidiscapuser.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "Discapacity")
public class Discapacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type_discapacity")
    private String typeDiscapacity;

    @Column(name = "description_discapacity")
    private String descriptionDiscapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeDiscapacity() {
        return typeDiscapacity;
    }

    public void setTypeDiscapacity(String typeDiscapacity) {
        this.typeDiscapacity = typeDiscapacity;
    }

    public String getDescriptionDiscapacity() {
        return descriptionDiscapacity;
    }

    public void setDescriptionDiscapacity(String descriptionDiscapacity) {
        this.descriptionDiscapacity = descriptionDiscapacity;
    }
}
