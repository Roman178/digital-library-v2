package org.example.domain.model;

public class ErrorPrinter {
    public void printError(Exception e) {
        System.out.println("\n=== ERROR ===");
        System.out.println(e.getMessage());
        e.printStackTrace();
        System.out.println("=============\n");
    }}
