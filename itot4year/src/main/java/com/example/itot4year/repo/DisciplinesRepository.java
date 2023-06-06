package com.example.itot4year.repo;

import com.example.itot4year.models.Disciplines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Хранилище дисциплин
 * Соответствует таблице disciplines в БД
 */
public interface DisciplinesRepository extends JpaRepository<Disciplines, Integer> {

    /**
     * Проверяет наличие дисциплины по ее индексу и учебному плану
     * @param index - индекс дисциплины
     * @param code - сод учебного плана
     * @return
     */
    boolean existsDisciplinesByIndexDisciplineAndCodeCurricula(String index, Integer code);

    /**
     * Возращает дисциплину по ее индексу и коду учебного плана
     * @param index - индекс дисциплины
     * @param code - код учебного плана
     * @return
     */
    Disciplines findDisciplinesByIndexDisciplineAndCodeCurricula(String index, Integer code);

    /**
     * Получаем дисциплины по учбному плану
     * @param code - код учебного плана
     * @return
     */
    List<Disciplines> findDisciplinesByCodeCurricula(Integer code);

}
