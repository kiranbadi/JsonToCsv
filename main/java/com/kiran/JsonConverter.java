package com.kiran;

import com.kiran.helpers.JsonHelper;
import com.kiran.model.Item;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonConverter {
    private static String  filePath ="src/main/resources/sample.json";
    public static void main(String args[]) throws IOException {
        JsonHelper.converter();
    }
}
