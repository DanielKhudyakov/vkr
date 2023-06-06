package com.example.itot4year.repo;

import com.example.itot4year.models.CompetenciesDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище компетенций по дисциплинам
 * Соответствует таблице competencies_discipline в БД
 */
public interface CompetenciesDisciplineRepository extends JpaRepository<CompetenciesDiscipline, Integer> {

    /**
     * Функция, которая проверят наличие компетенции у дисциплины
     * Абстрактно формирует SQL запрос
     * @param comp - компетенция
     * @param dis - дисциплина
     * @return
     */
    boolean existsCompetenciesDisciplineByCodeCompetenceAndCodeDiscipline(String comp, Integer dis);
}
