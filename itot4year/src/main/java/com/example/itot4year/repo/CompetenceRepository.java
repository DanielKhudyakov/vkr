package com.example.itot4year.repo;

import com.example.itot4year.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище компетенций
 * Соответствует таблице competence в БД
 */
public interface CompetenceRepository extends JpaRepository<Competence, String> {
}
