package com.tickettakeit.domain.file.controller;

import com.tickettakeit.domain.file.dto.FileInfo;
import com.tickettakeit.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class FileRestController {
    private final FileService fileService;
    private static final String FILE_ROOT_PATH = "/tmp/";
    @GetMapping("/api/download/{fileId}")
    public void download(HttpServletResponse response, @PathVariable("fileId") Integer fileId) throws IOException {
        FileInfo fileInfo = fileService.getFileInfo(fileId);
        Path path = Paths.get(FILE_ROOT_PATH + fileInfo.getSaveFileName());
        long fileLength = Files.size(path);

        response.setHeader("Content-Disposition", "inline");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", fileInfo.getContentType());
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try(
                FileInputStream fis = new FileInputStream(FILE_ROOT_PATH + fileInfo.getSaveFileName());
                OutputStream out = response.getOutputStream();
        ){
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
    }
}