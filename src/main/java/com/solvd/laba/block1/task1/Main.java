package com.solvd.laba.block1.task1;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2)
            System.out.println("Enter name and surname as args");
        else
            System.out.println("Hi, " + args[0] + " " + args[1] + "!");
    }
}
