package com.tickettakeit.global.controller;

import com.tickettakeit.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainMvcController {
    private final ReservationService reservationService;

    @GetMapping("/takeit")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/detail")
    public String detailPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "detail";
    }
    @GetMapping("/review")
    public String reviewPage() {
        return "review";
    }
    @GetMapping("/reserve")
    public String reservePage(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("reservationDate", reservationService.generateRandomDate());
        return "reserve";
    }
    @GetMapping("/myreservation")
    public String myReservationPage(Principal principal) {
        if(principal != null) {
            return "/myreservation";
        } else {
            return "bookinglogin";
        }
    }
    @GetMapping("/bookinglogin")
    public String bookingLoginPage() {
        return "bookinglogin";
    }
    @GetMapping("/reviewwrite")
    public String reviewWritePage(@RequestParam("productId")Integer productId,
                                  @RequestParam("reservationInfoId")Integer reservationInfoId,
                                  @RequestParam("tit")String productDescription,
                                  Model model) {
        model.addAttribute("productId", productId);
        model.addAttribute("reservationInfoId", reservationInfoId);
        model.addAttribute("productDescription", productDescription);
        return "reviewwrite";
    }
}
