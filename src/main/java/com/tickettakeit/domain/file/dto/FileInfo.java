package com.tickettakeit.domain.file.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileInfo {
    private Integer id;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private String createDate;
    private String modifyDate;
}
