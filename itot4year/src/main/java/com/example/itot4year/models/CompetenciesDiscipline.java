package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "competencies_discipline"
 * Представляет одну компетенцию по дисциплине
 */
@Entity
@Table(name = "competencies_discipline")
public class CompetenciesDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id_cd;
    @Column(name = "code_competence")
    private String codeCompetence;
    @Column(name = "code_discipline")
    private Integer codeDiscipline;

    public Integer getId_cd() {
        return id_cd;
    }

    public void setId_cd(Integer id_cd) {
        this.id_cd = id_cd;
    }

    public String getCodeCompetence() {
        return codeCompetence;
    }

    public void setCodeCompetence(String code_competence) {
        this.codeCompetence = code_competence;
    }

    public Integer getCodeDiscipline() {
        return codeDiscipline;
    }

    public void setCodeDiscipline(Integer code_discipline) {
        this.codeDiscipline = code_discipline;
    }

    public CompetenciesDiscipline () {}

    public CompetenciesDiscipline(String code_competence, Integer code_discipline) {
        this.codeCompetence = code_competence;
        this.codeDiscipline = code_discipline;
    }
}
