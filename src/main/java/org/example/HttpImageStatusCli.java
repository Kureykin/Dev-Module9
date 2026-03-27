package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus(){
        Scanner scan = new Scanner(System.in);
        int statusCode = 0;
        boolean endOfInput = false;

        while (!endOfInput) {
            try {
                System.out.println("Enter HTTP status code");
                System.out.print(">> ");
                statusCode = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
                scan.nextLine();
                continue;
            }
            endOfInput = true;
        }

        try {
            new HttpStatusImageDownloader().downloadStatusImage(statusCode);
        } catch (PostNotFoundException e) {
            System.out.println("There is not image for HTTP status " + statusCode);
        }
    }
}
