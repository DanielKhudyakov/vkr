package com.example.itot4year.repo;

import com.example.itot4year.models.Control;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище контроля по дисциплинам
 * Соответствует таблице control в БД
 */
public interface ControlRepository extends JpaRepository<Control, Integer> {
}
