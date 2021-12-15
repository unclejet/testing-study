package com.uj.study.maven.it;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/2 上午8:54
 * @description：
 */
public class RestIT {
    @Test
    public void whenSendingGet_thenMessageIsReturned() throws IOException {
        String url = "http://localhost:8999";
        URLConnection connection = new URL(url).openConnection();
        try (InputStream response = connection.getInputStream();
             Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.nextLine();
            assertEquals("Welcome to Baeldung!", responseBody);
        }
    }
}