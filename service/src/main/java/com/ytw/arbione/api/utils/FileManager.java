package com.ytw.arbione.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class);

    public String getContent(String file) {
        String data = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            data += reader.readLine();
        } catch (IOException e) {
            logger.error("Can't read from file: {}", file);
        }
        return data;
    }
}
