package com.tickettakeit.domain.file.service.impl;

import com.tickettakeit.domain.file.dao.FileDAO;
import com.tickettakeit.domain.file.dto.FileInfo;
import com.tickettakeit.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private static final String FILE_ROOT_PATH = "/tmp/img/";
    private static final String FILE_PATH = "img/";
    private final FileDAO fileDAO;

    @Override
    public FileInfo getFileInfo(Integer fileId) {
        return fileDAO.selectFileInfoById(fileId);
    }

    @Override
    public Integer uploadFile(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        try (
                FileOutputStream fos = new FileOutputStream(FILE_ROOT_PATH + uuid + "_" + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
        } catch (Exception e) {
            throw new RuntimeException("file Save Error");
        }

        return fileDAO.insertFileInfo(file.getOriginalFilename(),
                FILE_PATH + uuid + "_" + file.getOriginalFilename(),
                file.getContentType());
    }
}
