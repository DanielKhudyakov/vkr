package com.example.itot4year.repo;

import com.example.itot4year.models.Educational_standard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище образовательных стандартов
 * Соответствует таблице educational_standard в БД
 */
public interface Educational_standardRepository extends JpaRepository<Educational_standard, Integer> {
}
