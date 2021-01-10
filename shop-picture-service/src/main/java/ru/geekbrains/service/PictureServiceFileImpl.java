/**
 * Последние изменения от 10.01
 * 1. filePathFromDirectory - становиться final.
 * 2. Добавлен метод вычисления пути и удаления его с диска.
 */

package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.model.Picture;
import ru.geekbrains.persist.model.PictureData;
import ru.geekbrains.persist.repo.PictureRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class PictureServiceFileImpl implements PictureService{

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceFileImpl.class);
    private static final Path filePathFromDirectory = Paths.get(System.getProperty("user.dir"), "pictures");

    private final PictureRepository pictureRepository;

    static {
        if (Files.notExists(filePathFromDirectory)){
            try {
                Files.createDirectories(filePathFromDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Autowired
    public PictureServiceFileImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    @Override
    public Optional<String> getPictureContentType(Long id) {
        return this.pictureRepository.findById(id).map(Picture::getContentType);
    }

    @Override
    public Optional<byte[]> getPictureDataById(Long id) {
        return this.pictureRepository.findById(id)
                .map(picture -> Paths.get(filePathFromDirectory.toString(), picture.getPictureData().getFileName()))
                .map(path -> {
                    try {
                        return Files.readAllBytes(path);
                    } catch (IOException e) {
                        logger.error("not open file " + e);
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public PictureData createPictureData(byte[] picture) {
        String fileName = UUID.randomUUID().toString();
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(filePathFromDirectory.toString(), fileName))){
            outputStream.write(picture);
        } catch (IOException e){
            logger.error("File is missing: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return new PictureData(fileName);
    }

    /**
     * Удаление файлов на диске.
     * В поиске файла участвует постоянная filePathFromDirectory, которая опеределяется при запуске данного сервиса.
     * В случае ошибки вывод запись в log, а также кидает ошибку Runtime!
     * @param picture передача объекта, который в любом случае содержит объект PictureData, который
     *                в свою очередь содержит имя файла.
     */
    @Override
    public void deletePictureData(Picture picture) {
        this.pictureRepository.findById(picture.getId()).stream()
                .map(Picture::getPictureData)
                .map(PictureData::getFileName)
                .forEach(s -> {
                    try {
                        Files.deleteIfExists(Paths.get(filePathFromDirectory.toString(), s));
                    } catch (IOException e) {
                        logger.error("file not found {} ,{}", s, e.getMessage());
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public Picture getPictureById(Long id) {
        return this.pictureRepository.findById(id).orElse(null);
    }
}
