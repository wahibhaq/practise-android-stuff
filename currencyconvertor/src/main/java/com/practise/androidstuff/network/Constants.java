package com.practise.androidstuff.network;

/**
 * To store information which will remain fixed e.g api keys and base url.
 * Idea taken from https://github.com/CasterIO/Tasko/blob/forecastio/app/src/main/java/com/donnfelker/tasko/Constants.java
 */
public final class Constants {

    public static final class Injection {
        private Injection() {}

        public static final class Named {
            private Named() {}
            public static final String MASHAPE_API_KEY = "X-Mashape-Key";
            public static final String MASHAPE_API_KEY_VALUE = "5YR3E5aBdPmshmzLaAsUw0X9OtFUp1CpqeJjsnBKGuCdczadYD";
            public static final String CURRENCY_CONVERTOR_BASE_URL_KEY = "base_url";
            public static final String CURRENCY_CONVERTOR_BASE_URL =
                    "https://currencyconverter.p.mashape.com";
        }
    }
}
