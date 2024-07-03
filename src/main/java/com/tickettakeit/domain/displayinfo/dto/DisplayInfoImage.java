package com.tickettakeit.domain.displayinfo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DisplayInfoImage {
    private String contentType;
    private String createDate;
    private boolean deleteFlag;
    private int displayInfoId;
    private int displayInfoImageId;
    private int fileId;
    private String fileName;
    private String modifyDate;
    private String saveFileName;
}
