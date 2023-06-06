package com.example.itot4year.repo;

import com.example.itot4year.models.TypeOfControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Хранилище типов контроля
 * Соответствует таблице type_of_control в БД
 */
public interface TypeOfControlRepository extends JpaRepository<TypeOfControl, Integer> {

    /**
     * Проверяет наличие данного типа контроля в БД
     * @param name_type_of_control - тип контроля
     * @return
     */
    boolean existsTypeOfControlByNameTypeOfControl(String name_type_of_control);

    /**
     * Возвращает информацию о типе занятия
     * @param type - тип контроля
     * @return
     */
    TypeOfControl findTypeOfControlByNameTypeOfControl(String type);

}
