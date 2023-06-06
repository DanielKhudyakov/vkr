package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "type_of_control"
 * Отображает тип контроля
 */
@Entity
@Table(name = "type_of_control")
public class TypeOfControl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_type_control;
    @Column(name = " name_type_of_control")
    private String nameTypeOfControl;

    public Integer getCode_type_control() {
        return code_type_control;
    }

    public void setCode_type_control(Integer code_type_control) {
        this.code_type_control = code_type_control;
    }

    public String getNameTypeOfControl() {
        return nameTypeOfControl;
    }

    public void setNameTypeOfControl(String name_type_of_control) {
        this.nameTypeOfControl = name_type_of_control;
    }

    public TypeOfControl(String name_type_of_control) {
        this.nameTypeOfControl = name_type_of_control;
    }

    public TypeOfControl() {}
}
