package com.ytw.arbione.api.utils;

import org.junit.jupiter.api.Test;

public class FileManagerTest {
    @Test
    public void readsCorrectly() throws Exception {
        FileManager fileManager = new FileManager();
        System.out.println(fileManager.getContent("src/test/resources/stringFile"));
    }

}