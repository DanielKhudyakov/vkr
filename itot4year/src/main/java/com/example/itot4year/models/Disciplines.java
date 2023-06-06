package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "disciplines"
 * Отображает одну дисциплину
 */
@Entity
@Table(name = "disciplines")
public class Disciplines {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_discipline;
    @Column(name = "index_discipline")
    private String indexDiscipline;
    @Column
    private String name_discipline;
    @Column(name = "code_curricula")
    private Integer codeCurricula;
    @Column
    private Double quantity_ze_to_plan;
    @Column
    private Double hours_ze;
    @Column
    private Double general_quantity_hours_to_plan;
    @Column
    private Double general_quantity_contact_hours;
    @Column
    private Double general_quantity_sr_hours;
    @Column
    private Double general_quantity_control_hours;

    public Integer getCode_discipline() {
        return code_discipline;
    }

    public void setCode_discipline(Integer code_discipline) {
        this.code_discipline = code_discipline;
    }

    public String getIndexDiscipline() {
        return indexDiscipline;
    }

    public void setIndexDiscipline(String index_discipline) {
        this.indexDiscipline = index_discipline;
    }

    public String getName_discipline() {
        return name_discipline;
    }

    public void setName_discipline(String name_discipline) {
        this.name_discipline = name_discipline;
    }

    public Integer getCodeCurricula() {
        return codeCurricula;
    }

    public void setCodeCurricula(Integer code_curricula) {
        this.codeCurricula = code_curricula;
    }

    public Double getQuantity_ze_to_plan() {
        return quantity_ze_to_plan;
    }

    public void setQuantity_ze_to_plan(Double quantity_ze_to_plan) {
        this.quantity_ze_to_plan = quantity_ze_to_plan;
    }

    public Double getHours_ze() {
        return hours_ze;
    }

    public void setHours_ze(Double hours_ze) {
        this.hours_ze = hours_ze;
    }

    public Double getGeneral_quantity_hours_to_plan() {
        return general_quantity_hours_to_plan;
    }

    public void setGeneral_quantity_hours_to_plan(Double general_quantity_hours_to_plan) {
        this.general_quantity_hours_to_plan = general_quantity_hours_to_plan;
    }

    public Double getGeneral_quantity_contact_hours() {
        return general_quantity_contact_hours;
    }

    public void setGeneral_quantity_contact_hours(Double general_quantity_contact_hours) {
        this.general_quantity_contact_hours = general_quantity_contact_hours;
    }

    public Double getGeneral_quantity_sr_hours() {
        return general_quantity_sr_hours;
    }

    public void setGeneral_quantity_sr_hours(Double general_quantity_sr_hours) {
        this.general_quantity_sr_hours = general_quantity_sr_hours;
    }

    public Double getGeneral_quantity_control_hours() {
        return general_quantity_control_hours;
    }

    public void setGeneral_quantity_control_hours(Double general_quantity_control_hours) {
        this.general_quantity_control_hours = general_quantity_control_hours;
    }

    public Disciplines() {}

    public Disciplines(String index_discipline, String name_discipline,
                       Integer code_curricula, Double quantity_ze_to_plan,
                       Double hours_ze, Double general_quantity_hours_to_plan,
                       Double general_quantity_contact_hours, Double general_quantity_sr_hours,
                       Double general_quantity_control_hours) {
        this.indexDiscipline = index_discipline;
        this.name_discipline = name_discipline;
        this.codeCurricula = code_curricula;
        this.quantity_ze_to_plan = quantity_ze_to_plan;
        this.hours_ze = hours_ze;
        this.general_quantity_hours_to_plan = general_quantity_hours_to_plan;
        this.general_quantity_contact_hours = general_quantity_contact_hours;
        this.general_quantity_sr_hours = general_quantity_sr_hours;
        this.general_quantity_control_hours = general_quantity_control_hours;
    }
}
