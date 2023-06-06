package com.example.itot4year.repo;

import com.example.itot4year.models.Curricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Хранилище учебных планов
 * Соответствует таблице curricula в БД
 */
public interface CurriculaRepository extends JpaRepository<Curricula, Integer> {
    /**
     * Проверяет наличие учебного плана по его имени
     * @param name - уникальное имя учебного плана
     * @return
     */
    boolean existsCurriculaByNameCurricula(String name);

    /**
     * Возращает учебный план по его имени
     * @param name - уникальное имя учебного плана
     * @return учебный план
     */
    Curricula findCurriculaByNameCurricula(String name);

    /**
     * Полчучаем учебный план
     * @param pd - код направления и профиля
     * @param year - год начал подготовки
     * @return
     */
    List<Curricula> findCurriculaByIdPdAndYearStartTraining(Integer pd, Integer year);
}
