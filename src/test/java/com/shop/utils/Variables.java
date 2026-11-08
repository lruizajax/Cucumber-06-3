package com.shop.utils;

public class Variables {

    public static final String VALID_EMAIL = "mruizg@gmail.com";
    public static final String VALID_PASSWORD = "*9Q>:ir7Tnb@V&d";

    public static final String BASE_URL = "https://demowebshop.tricentis.com";

    private static ThreadLocal<String> registeredEmail = new ThreadLocal<>();
    private static ThreadLocal<String> registeredPassword = new ThreadLocal<>();

    public static void setRegisteredEmail(String email) {
        registeredEmail.set(email);
    }

    public static String getRegisteredEmail() {
        return registeredEmail.get();
    }

    public static void setRegisteredPassword(String password) {
        registeredPassword.set(password);
    }

}
