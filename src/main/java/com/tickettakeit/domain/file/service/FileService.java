package com.tickettakeit.domain.file.service;

import com.tickettakeit.domain.file.dto.FileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileInfo getFileInfo(Integer fileId);
    Integer uploadFile(MultipartFile file);
}
