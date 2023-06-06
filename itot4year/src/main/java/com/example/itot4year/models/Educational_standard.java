package com.example.itot4year.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Данный класс соответствует записи в таблице БД "educational_standard"
 * Отображает образовательный стандарт
 */
@Entity
@Table(name = "educational_standard")
public class Educational_standard {

    @Id
    @Column
    private Integer number;
    @Column
    private String data;
    @Column
    private String description;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Educational_standard(Integer number, String data, String description) {
        this.number = number;
        this.data = data;
        this.description = description;
    }

    public Educational_standard() {}
}
