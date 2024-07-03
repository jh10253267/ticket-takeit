package com.tickettakeit.domain.displayinfo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DisplayInfo {
    private int productId;
    private int categoryId;
    private int displayInfoId;
    private String categoryName;
    private String productDescription;
    private String productContent;
    private String productEvent;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String telephone;
    private String homepage;
    private String email;
    private String createDate;
    private String modifyDate;
}
