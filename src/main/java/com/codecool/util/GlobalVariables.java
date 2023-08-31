package com.codecool.util;

import io.github.cdimascio.dotenv.Dotenv;

public class GlobalVariables {
    private static Dotenv dotenv = Dotenv.load();
    public static final String VALID_USERNAME = dotenv.get("VALID_USERNAME");
    public static final String VALID_PASSWORD = dotenv.get("VALID_PASSWORD");
    public static final String INVALID_USERNAME = dotenv.get("INVALID_USERNAME");
    public static final String INVALID_PASSWORD = dotenv.get("INVALID_PASSWORD");
    public static final String BASE_URL = dotenv.get("BASE_URL");

}
