package com.example.itot4year.repo;

import com.example.itot4year.models.ProfileOfDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

/**
 * Хранилище профилей направлений
 * Соответствует таблице profile_of_direction в БД
 */
public interface ProfileOfDirectionRepository extends JpaRepository<ProfileOfDirection, Integer> {

    /**
     * Проверяет наличие профиля по направлению в БД
     * @param direction - направление
     * @param profile - профиль
     * @return
     */
    boolean existsProfileOfDirectionByCodeDirectionAndCodeProfile( String direction,Integer profile);

    /**
     * Возвращает запись из БД
     * @param direction - направление
     * @param profile - профиль
     * @return
     */
    ProfileOfDirection findProfileOfDirectionByCodeDirectionAndAndCodeProfile(String direction,Integer profile);

    /**
     * Возвращает профили по направлению
     * @param direction - направление
     * @return
     */
    @Procedure
    List<Object> get_profile_of_direction(String direction);

    /**
     * Возвращает годы начала подготовки учебных планов по профилю и направлению
     * @param pd - профиль и напрвление (ключ)
     * @return
     */
    @Procedure
    List<Object> get_curricula(Integer pd);


}
