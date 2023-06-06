package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "profile"
 * Отображает информацию о профиле
 */
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_profile")
    private Integer codeProfile;
    @Column(name = "name_profile")
    private String nameProfile;

    public Integer getCodeProfile() {
        return codeProfile;
    }

    public void setCodeProfile(Integer code_profile) {
        this.codeProfile = code_profile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String name_profile) {
        this.nameProfile = name_profile;
    }

    public Profile(String name_profile) {
        this.nameProfile = name_profile;
    }

    public Profile() {}
}
