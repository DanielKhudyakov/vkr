package com.example.itot4year.models;

import jakarta.persistence.*;

/**
 * Данный класс соответствует записи в таблице БД "type_of_activity"
 * Отображает тип активности
 */
@Entity
@Table(name = "type_of_activity")
public class TypeOfActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer code_type_of_activity;
    @Column(name = "name_type_of_activity")
    private String nameTypeOfActivity;

    public Integer getCode_type_of_activity() {
        return code_type_of_activity;
    }

    public void setCode_type_of_activity(Integer code_type_of_activity) {
        this.code_type_of_activity = code_type_of_activity;
    }

    public String getNameTypeOfActivity() {
        return nameTypeOfActivity;
    }

    public void setNameTypeOfActivity(String name_type_of_activity) {
        this.nameTypeOfActivity = name_type_of_activity;
    }

    public TypeOfActivity(String name_type_of_activity) {
        this.nameTypeOfActivity = name_type_of_activity;
    }

    public TypeOfActivity() {}
}
