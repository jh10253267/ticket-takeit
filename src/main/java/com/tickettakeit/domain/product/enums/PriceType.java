package com.tickettakeit.domain.product.enums;

import java.util.Arrays;

public enum PriceType {
    ADULT("A", "성인") {
        @Override
        public PriceType getPriceType(String type) {
            return ADULT;
        }
    },
    YOUTH("Y", "청소년") {
        @Override
        public PriceType getPriceType(String type) {
            return YOUTH;
        }
    },
    CHILD("B", "유아") {
        @Override
        public PriceType getPriceType(String type) {
            return CHILD;
        }
    },
    LOCAL("C", "지역주민") {
        @Override
        public PriceType getPriceType(String type) {
            return LOCAL;
        }
    },
    SET("S", "세트") {
        @Override
        public PriceType getPriceType(String type) {
            return SET;
        }
    },
    DISABLED("D", "장애인") {
        @Override
        public PriceType getPriceType(String type) {
            return DISABLED;
        }
    },
    EARLY_BIRD("E", "얼리버드") {
        @Override
        public PriceType getPriceType(String type) {
            return EARLY_BIRD;
        }
    },
    VIP("V", "VIP") {
        @Override
        public PriceType getPriceType(String type) {
            return VIP;
        }
    },
    R_SEAT("R", "R석") {
        @Override
        public PriceType getPriceType(String type) {
            return R_SEAT;
        }
    },
    B_SEAT("B", "B석") {
        @Override
        public PriceType getPriceType(String type) {
            return B_SEAT;
        }
    },
    S_SEAT("S", "S석") {
        @Override
        public PriceType getPriceType(String type) {
            return S_SEAT;
        }
    };

    private final String type;
    private final String text;

    PriceType(String type, String text) {
        this.type = type;
        this.text = text;
    }
    public abstract PriceType getPriceType(String type);

    public static String priceType(String type) {
        PriceType priceType = Arrays.stream(values())
                .filter(v -> v.type.equals(type))
                .findFirst()
                .orElse(PriceType.ADULT);

        return priceType.getPriceType(type).text;
    }
}
