package com.example.itot4year.repo;

import com.example.itot4year.models.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище направлений обучения
 * Соответствует таблице direction в БД
 */
public interface DirectionRepository extends JpaRepository<Direction, String> {
}
