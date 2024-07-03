package com.tickettakeit.domain.displayinfo.controller;

import com.tickettakeit.domain.displayinfo.dto.DisplayInfoResponse;
import com.tickettakeit.domain.displayinfo.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class DisplayInfoRestController {
    private final DisplayInfoService displayInfoService;

    @GetMapping("/{displayInfoId}")
    public DisplayInfoResponse getDisplayInfo(@PathVariable("displayInfoId") int displayInfoId) {
        DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
        displayInfoResponse.setDisplayInfo(displayInfoService.getDisplayInfo(displayInfoId));
        displayInfoResponse.setDisplayInfoImage(displayInfoService.getDisplayInfoImage(displayInfoId));
        displayInfoResponse.setProductImages(displayInfoService.getProductImages(displayInfoId));
        displayInfoResponse.setComments(displayInfoService.getComments(displayInfoId));
        displayInfoResponse.setProductPrices(displayInfoService.getProductPrices(displayInfoId));
        displayInfoResponse.setAverageScore(displayInfoService.getAverageScore(displayInfoId));

        return displayInfoResponse;
    }
}
