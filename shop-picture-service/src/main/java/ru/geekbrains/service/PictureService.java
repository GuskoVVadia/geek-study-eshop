/**
 * Изменения от 10.01
 * 1. добавлен метод для удаление файлов с диска.
 *
 * Изменения от 11.01:
 * 1. добавлен метод поиска объекта Picture по его id.
 * 2. добавлен метод удаления объекта Picture по его id.
 */
package ru.geekbrains.service;

import ru.geekbrains.persist.model.Picture;
import ru.geekbrains.persist.model.PictureData;

import java.util.Optional;

public interface PictureService {
    Optional<String> getPictureContentType(Long id);
    Optional<byte[]> getPictureDataById(Long id);
    PictureData createPictureData(byte[] picture);

    /**
     * Удаление файла с диска
     * @param picture объект, который в себе инкапсулирует имена файлов.
     */
    void deletePictureData(Picture picture);

    /**
     * Поиск объекта-сущности по его id
     * @param id id объекта
     * @return найденный объект
     */
    Picture getPictureById(Long id);

    /**
     * Метод удаления объекта Picture по его id
     * @param id непосредственно id объекта
     */
    void deletePictureById(Long id);
}
