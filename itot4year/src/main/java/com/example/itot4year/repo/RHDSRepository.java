package com.example.itot4year.repo;

import com.example.itot4year.models.RHDS;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранилище информации о занятиях по дисциплине
 * Соответствует таблице rhds в БД
 */
public interface RHDSRepository extends JpaRepository<RHDS, Integer>{
}
