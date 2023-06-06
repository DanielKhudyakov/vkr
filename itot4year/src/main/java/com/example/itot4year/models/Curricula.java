package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "curricula"
 * Описывает один учебный план
 */
@Entity
@Table(name = "curricula")
public class Curricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_curricula;
    @Column(name = "name_curricula")
    private String nameCurricula;
    @Column(name = "year_start_training")
    private Integer yearStartTraining;
    @Column
    private Integer number_educational_standard;
    @Column(name = "id_pd")
    private Integer idPd;
    @Column
    private String statement;
    @Column
    private String type_of_education;
    @Column
    private String form_of_training;

    public Integer getCode_curricula() {
        return code_curricula;
    }

    public void setCode_curricula(Integer code_curricula) {
        this.code_curricula = code_curricula;
    }

    public String getNameCurricula() {
        return nameCurricula;
    }

    public void setNameCurricula(String name_curricula) {
        this.nameCurricula = name_curricula;
    }

    public Integer getYearStartTraining() {
        return yearStartTraining;
    }

    public void setYearStartTraining(Integer year_start_training) {
        this.yearStartTraining = year_start_training;
    }

    public Integer getNumber_educational_standard() {
        return number_educational_standard;
    }

    public void setNumber_educational_standard(Integer number_educational_standard) {
        this.number_educational_standard = number_educational_standard;
    }

    public Integer getIdPd() {
        return idPd;
    }

    public void setIdPd(Integer id_pd) {
        this.idPd = id_pd;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getType_of_education() {
        return type_of_education;
    }

    public void setType_of_education(String type_of_education) {
        this.type_of_education = type_of_education;
    }

    public String getForm_of_training() {
        return form_of_training;
    }

    public void setForm_of_training(String form_of_training) {
        this.form_of_training = form_of_training;
    }

    public Curricula(){}


    public Curricula(String nameCurricula, Integer year_start_training,
                     Integer number_educational_standard, Integer id_pd,
                     String statement, String type_of_education,
                     String form_of_training) {
        this.nameCurricula = nameCurricula;
        this.yearStartTraining = year_start_training;
        this.number_educational_standard = number_educational_standard;
        this.idPd = id_pd;
        this.statement = statement;
        this.type_of_education = type_of_education;
        this.form_of_training = form_of_training;
    }
}
