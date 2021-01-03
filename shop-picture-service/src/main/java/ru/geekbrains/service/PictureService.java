package ru.geekbrains.service;

import ru.geekbrains.persist.model.PictureData;

import java.util.Optional;

public interface PictureService {
    Optional<String> getPictureContentType(Long id);
    Optional<byte[]> getPictureDataById(Long id);
    PictureData createPictureData(byte[] picture);
}
