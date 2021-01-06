package ru.geekbrains.service;

import ru.geekbrains.persist.model.PictureData;

import java.nio.file.FileSystems;
import java.util.Optional;

public class PictureServiceFileImpl implements PictureService{

    @Override
    public Optional<String> getPictureContentType(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<byte[]> getPictureDataById(Long id) {
        return Optional.empty();
    }

    @Override
    public PictureData createPictureData(byte[] picture) {
        return null;
    }
}
