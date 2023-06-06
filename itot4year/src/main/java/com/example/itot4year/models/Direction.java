package com.example.itot4year.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Данный класс соответствует записи в таблице БД "direction"
 * Отображает направление
 */
@Entity
@Table(name = "direction")
public class Direction {

    @Id
    @Column
    private String code_direction;
    @Column
    private String name_direction;

    public String getCode_direction() {
        return code_direction;
    }

    public void setCode_direction(String code_direction) {
        this.code_direction = code_direction;
    }

    public String getName_direction() {
        return name_direction;
    }

    public void setName_direction(String name_direction) {
        this.name_direction = name_direction;
    }

    public Direction(String code_direction, String name_direction) {
        this.code_direction = code_direction;
        this.name_direction = name_direction;
    }

    public Direction(String direct) {
        String[] spl = direct.split(" ");
        this.code_direction = spl[0];
        this.name_direction = spl[1];
    }
    public Direction() {}
}
