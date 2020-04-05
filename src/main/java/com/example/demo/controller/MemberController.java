package com.example.demo.controller;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MemberController {
    public String menu(){
        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return name;
    }
}