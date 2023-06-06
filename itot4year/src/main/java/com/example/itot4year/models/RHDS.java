package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "rhds"
 * Отображает распределенние часов по дисциплине по типу занятия
 */
@Entity
@Table(name = "rhds")
public class RHDS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_rhds;
    @Column
    private Double number_of_hours;
    @Column
    private Integer semester;
    @Column
    private Integer code_type_of_activity;
    @Column
    private Integer code_discipline;

    public Integer getCode_rhds() {
        return code_rhds;
    }

    public void setCode_rhds(Integer code_rhds) {
        this.code_rhds = code_rhds;
    }

    public Double getNumber_of_hours() {
        return number_of_hours;
    }

    public void setNumber_of_hours(Double number_of_hours) {
        this.number_of_hours = number_of_hours;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getCode_type_of_activity() {
        return code_type_of_activity;
    }

    public void setCode_type_of_activity(Integer code_type_of_activity) {
        this.code_type_of_activity = code_type_of_activity;
    }

    public Integer getCode_discipline() {
        return code_discipline;
    }

    public void setCode_discipline(Integer code_discipline) {
        this.code_discipline = code_discipline;
    }

    public RHDS() {}

    public RHDS(Double number_of_hours, Integer semester, Integer code_type_of_activity, Integer code_discipline) {
        this.number_of_hours = number_of_hours;
        this.semester = semester;
        this.code_type_of_activity = code_type_of_activity;
        this.code_discipline = code_discipline;
    }
}
