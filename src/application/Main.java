package application;

import application.menu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MainMenu menu = new MainMenu(sc);
        menu.show();

        sc.close();
    }
}