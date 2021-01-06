package ru.geekbrains.persist.model;

import javax.persistence.*;
import java.nio.file.FileSystems;

@Entity
@Table(name = "pictures_data")
public class PictureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "data", length = 33554430)
    private byte[] data;

    @Column(name = "file_name")
    private String fileName;

    public PictureData() {
    }

    public PictureData(byte[] data) {
        this.data = data;
    }

    public PictureData(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
