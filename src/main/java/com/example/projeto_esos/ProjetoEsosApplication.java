package com.example.projeto_esos;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoEsosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoEsosApplication.class, args);

        try {
            String url = "http://localhost:8080";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Abra manualmente no navegador: " + url);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
