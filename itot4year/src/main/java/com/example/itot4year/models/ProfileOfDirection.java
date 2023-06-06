package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "profile_of_direction"
 * Отображает профиль направления
 */
@Entity
@Table(name = "profile_of_direction")
public class ProfileOfDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id_pd;
    @Column(name = "code_profile")
    private  Integer codeProfile;
    @Column(name = "code_direction")
    private String codeDirection;

    public Integer getId_pd() {
        return id_pd;
    }

    public void setId_pd(Integer id_pd) {
        this.id_pd = id_pd;
    }

    public Integer getCodeProfile() {
        return codeProfile;
    }

    public void setCodeProfile(Integer code_profile) {
        this.codeProfile = code_profile;
    }

    public String getCodeDirection() {
        return codeDirection;
    }

    public void setCodeDirection(String code_direction) {
        this.codeDirection = code_direction;
    }

    public ProfileOfDirection() {}

    public ProfileOfDirection(Integer code_profile, String code_direction) {
        this.codeProfile = code_profile;
        this.codeDirection = code_direction;
    }
}
