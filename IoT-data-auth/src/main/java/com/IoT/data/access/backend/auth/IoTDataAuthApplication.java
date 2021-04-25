package com.IoT.data.access.backend.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author NIUNIU
 * @version 1.0
 * @date 2021/4/25 14:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IoTDataAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(IoTDataAuthApplication.class,args);
        buddha();
    }

    private static void buddha(){
        try {
            FileReader reader = new FileReader(Objects.requireNonNull(IoTDataAuthApplication.class.getClassLoader().getResource(".")).getPath() + "buddha.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            Object buddha = null;
            while ((buddha = bufferedReader.readLine()) != null) {
                System.out.println(buddha);
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
