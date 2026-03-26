package org.example;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super("Post is not found");
    }
}
