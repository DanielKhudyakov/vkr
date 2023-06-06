package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "control"
 * Описывает один контроль дисциплины
 */
@Entity
@Table(name = "control")
public class Control {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_control;
    @Column
    private Double hour;
    @Column
    private Integer semester;
    @Column
    private Integer code_type_control;
    @Column
    private Integer code_discipline;

    public Integer getCode_control() {
        return code_control;
    }

    public void setCode_control(Integer code_control) {
        this.code_control = code_control;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getCode_type_control() {
        return code_type_control;
    }

    public void setCode_type_control(Integer code_type_control) {
        this.code_type_control = code_type_control;
    }

    public Integer getCode_discipline() {
        return code_discipline;
    }

    public void setCode_discipline(Integer code_discipline) {
        this.code_discipline = code_discipline;
    }

    public Control() {}

    public Control(Double hour, Integer semester, Integer code_type_control, Integer code_discipline) {
        this.hour = hour;
        this.semester = semester;
        this.code_type_control = code_type_control;
        this.code_discipline = code_discipline;
    }
}
