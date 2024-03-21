package io.nextree.java.travelClub.ui.menu;

import io.nextree.java.travelClub.ui.console.ClubConsole;

import java.util.Scanner;

public class ClubMenu {
    private Scanner scanner;
    private ClubConsole console;

    public ClubMenu() {
        this.scanner = new Scanner(System.in);
        this.console = new ClubConsole();
    }

    public void show() {
        int inputNumber = 0;

        while(true) {
            displayMenu();
            inputNumber = selectMenu();
            switch(inputNumber) {
                case 1:
                     console.register();
                    break;
                case 2:
                    console.findAll();
                    break;
                case 3:
                    console.findById();
                    break;
                case 4:
                    console.findByName();
                    break;
                case 5:
                    console.modify();
                    break;
                case 6:
                    console.remove();
                    break;
                case 0:
                    //
                    return;
                default:
                    System.out.println("Choose again");

            }
        }
    }

    private void displayMenu() {
        System.out.println("...............");
        System.out.println("Club Menu");
        System.out.println("...............");
        System.out.println("1. Register");
        System.out.println("2. Find(All)");
        System.out.println("3. Find(ID)");
        System.out.println("4. Find(Name)");
        System.out.println("5. Modify");
        System.out.println("6. Remove");
        System.out.println("5. Modify");
        System.out.println("...............");
        System.out.println("0. Previous");
        System.out.println("...............");
    }

    private int selectMenu(){
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt(); // 숫자를 입력할 때 사용, 띄어쓰기 불가능
        if(menuNumber >= 0 && menuNumber <= 6) {
            scanner.nextLine(); // 문자+공백 입력시 사용, 띄어쓰기 가능
            return menuNumber;
        } else {
            System.out.println("It's a invalid number : " + menuNumber);
            return -1;
        }
    }
}
