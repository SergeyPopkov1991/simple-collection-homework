package com.company;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Введите номер, имя или команду(LIST)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("LIST")) {
                Set<String> allContacts = phoneBook.getAllContacts();
                for (String allContact : allContacts) {
                    System.out.println(allContact);
                }
            } else if (phoneBook.isValidName(input)) {
                if (!phoneBook.containsName(input)) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.printf("Введите номер телефона для абонента %s:%n", input);
                    String phone = scanner.nextLine();
                    if (phoneBook.isValidPhone(phone)) {
                        phoneBook.addContact(input, phone);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                } else {
                    System.out.printf("Имя %s есть в телефонной книге %n",input);
                    System.out.printf("Введите номер телефона для абонента %s:%n", input);
                    String phone = scanner.nextLine();
                    if (phoneBook.isValidPhone(phone)) {
                        phoneBook.addContact(input, phone);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                }

            } else if (phoneBook.isValidPhone(input)) {
                if (phoneBook.getContactByPhone(input).isEmpty()) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.printf("Введите имя абонента для номера “%s“:%n", input);
                    String name = scanner.nextLine();
                    if (phoneBook.isValidName(name)) {
                        phoneBook.addContact(name, input);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Неверный формат ввода");
                    }

                }
            }else {
                System.out.println("Неверный формат ввода");
                isExit = true;
            }

        }
    }
}