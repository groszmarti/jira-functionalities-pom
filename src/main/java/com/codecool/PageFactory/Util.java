package com.codecool.PageFactory;

import com.codecool.Main;
import io.github.cdimascio.dotenv.Dotenv;

public class Util {
    private static Dotenv dotenv = Dotenv.load();
    public static final String VALID_USERNAME = dotenv.get("VALID_USERNAME");
    public static final String VALID_PASSWORD = dotenv.get("VALID_PASSWORD");
    protected static final String INVALID_USERNAME = dotenv.get("INVALID_USERNAME");
    protected static final String INVALID_PASSWORD = dotenv.get("INVALID_PASSWORD");
    public static final String SRC = dotenv.get("SRC");

}
