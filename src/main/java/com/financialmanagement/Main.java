package com.financialmanagement;

import com.financialmanagement.controller.MainController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        try{
//            new MainController(System.out, new BufferedReader(new InputStreamReader(System.in))).run();
//        } catch (IOException e) {
//            System.err.println("No user Input");
//        }
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter your name: ");
        String name = input.readLine();
        System.out.println("Welcome " + name + " ,please enter your income.");

    }
}


