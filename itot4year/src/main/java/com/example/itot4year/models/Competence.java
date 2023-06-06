package com.example.itot4year.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

/**
 * Данный класс соответствует записи в таблице БД "competence"
 * Представляет одну компетенцию
 */
@Entity
@Table(name = "competence")
public class Competence {

    @Id
    @Column
    private String code_competence;
    @Column
    private String name_competence;

    public String getCode_competence() {
        return code_competence;
    }

    public void setCode_competence(String code_competence) {
        this.code_competence = code_competence;
    }

    public String getName_competence() {
        return name_competence;
    }

    public void setName_competence(String name_competence) {
        this.name_competence = name_competence;
    }

    public Competence(String code_competence, String name_competence) {
        this.code_competence = code_competence;
        this.name_competence = name_competence;
    }

    public Competence(List<String> list) {
        this.code_competence = list.get(0);
        this.name_competence = list.get(2);
    }

    public Competence() {}

}
