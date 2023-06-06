package com.example.itot4year.repo;

import com.example.itot4year.models.TypeOfActivity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище типов занятий
 * Соответствует таблице type_of_activity в БД
 */
public interface TypeOfActivityRepository extends JpaRepository<TypeOfActivity, Integer> {

    /**
     * Проверяет наличие данного типа занятия в БД
     * @param type - тип занятия
     * @return
     */
    boolean existsTypeOfActivityByNameTypeOfActivity(String type);

    /**
     * Возвращает информацию о типе занятия
     * @param type - тип занятия
     * @return
     */
    TypeOfActivity findTypeOfActivityByNameTypeOfActivity(String type);
}
