package com.example.itot4year.repo;

import com.example.itot4year.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Хранилище профилей
 * Соответствует таблице profile в БД
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    /**
     * Проверяет наличие профиля в БД
     * @param profile - название профиль
     * @return
     */
    boolean existsProfileByNameProfile(String profile);

    /**
     * Возвращает информацию по профилю
     * @param profile - имя профиля
     * @return
     */
    Profile findByNameProfile(String profile);

}
