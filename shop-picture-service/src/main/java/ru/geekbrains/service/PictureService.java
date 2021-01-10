/**
 * последние изменения от 10.01
 * 1. добавлен метод для удаление файлов с диска.
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
     * поиск
     * @param id
     * @return
     */
    Picture getPictureById(Long id);

    void
}
