package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus(){
        Scanner scan = new Scanner(System.in);
        int statusCode;

        System.out.println("Enter HTTP status code");
        System.out.print(">> ");
        statusCode = scan.nextInt();

        try {
            new HttpStatusImageDownloader().downloadStatusImage(statusCode);
        } catch (PostNotFoundException e) {
            System.out.println("There is not image for HTTP status " + statusCode);
        }
    }
}
