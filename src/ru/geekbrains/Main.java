package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        chooseTheGame();
    }

    public static void chooseTheGame() {
        System.out.println("Тут есть два задания на выбор - ");
        System.out.println("1. Угадать число.");
        System.out.println("2. Угадать слово.");
        System.out.println("Введи число 1 или 2:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            guessTheNumber();
        } else if (choice == 2) {
            startToTryToGuessAWord();
        } else {
            System.out.println("Нужно было ввести 1 или 2...");
        }
    }

    public static void startToTryToGuessAWord() {
        // Создать массив из слов. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано,
        // компьютер показывает буквы, которые стоят на своих местах.

        char[] hidedArray = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("\n" + "Попробуйте угадать одно из слово из списка слов:" + "\n"); // Печать массива слов
        for (int i = 0; i < words.length; i++) {                                              // Печать массива слов
            System.out.print(words[i] + "  ");                                                // Печать массива слов
            if ((i > 0) && i % 6 == 0) {                                                      // Печать массива слов
                System.out.println();                                                         // Печать массива слов
            }                                                                                 // Печать массива слов
        }                                                                                     // Печать массива слов

        Random rand = new Random();                    // Включаем рандомайззззер
        int x = rand.nextInt(25);                // Номер загаданного слова.
        String tryToGuess = words[x];                    // Слово из массива

        boolean b = false;
        while (!b) {
            b = guessTheWord(hidedArray, words, tryToGuess);
        }
    }

    public static boolean guessTheWord(char[] array, String[] words, String tryToGuess) {
        Scanner scanner = new Scanner(System.in);           //Сканнер для ввода слова

        System.out.print("\n" + "Введите слово: ");         //Попытка угадать слово
        String guessWord = scanner.next();                  //Попытка угадать слово

        if (guessWord.length() >= 15) {
            System.out.println("вы ввели слишком много букв, введите меньше 15 букв");

        } else {
            for (int i = 0; i < guessWord.length() && i < tryToGuess.length(); i++) {// сравнение введенного
                if (guessWord.charAt(i) == tryToGuess.charAt(i)) {                 // с клавиатуры слова
                    array[i] = guessWord.charAt(i);                                // с загаданным словом,
                }                                                                  // если символ совпал,
            }                                                                      // то заменяем "#" на символ
            if (guessWord.equals(tryToGuess)) {
                System.out.println("Вы угадали! Вы великолепны");
            } else {
                System.out.println("\n" + "Напоминаем слова:");
                for (int i = 0; i < words.length; i++) {                                    // Печать массива слов
                    System.out.print(words[i] + "  ");                                      // Печать массива слов
                    if ((i > 0) && i % 6 == 0) {                                            // Печать массива слов
                        System.out.println();                                               // Печать массива слов
                    }                                                                       // Печать массива слов
                }                                                                           // Печать массива слов
                System.out.println("\n" + "Вот что пока у нас выходит:");
                for (int i = 0; i < array.length; i++) {   //Печать скрытого массива
                    System.out.print(array[i]);            //Печать скрытого массива
                }                                          //Печать скрытого массива
            }
        }
        return (guessWord.equals(tryToGuess));
    }

    //Написать программу, которая загадывает случайное число от 0 до 9             !!!!!!!!!!!!!!! // Конец поиска слова // Конец поиска слова !!!!!!!!!!!!!!!
    // и пользователю дается 3 попытки угадать это число. При каждой попытке       !!!!!!!!!!!!!!! // Конец поиска слова // Конец поиска слова !!!!!!!!!!!!!!!
    // компьютер должен сообщить, больше ли указанное пользователем число,         !!!!!!!!!!!!!!! // Конец поиска слова // Конец поиска слова !!!!!!!!!!!!!!!
    // чем загаданное, или меньше. После победы или проигрыша выводится запрос –   !!!!!!!!!!!!!!! // Конец поиска слова // Конец поиска слова !!!!!!!!!!!!!!!
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).         !!!!!!!!!!!!!!! // Конец поиска слова // Конец поиска слова !!!!!!!!!!!!!!!

    public static void guessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            Random rand = new Random();
            int x = rand.nextInt(10);
            int y = x + 1;      // число не равное X
            int z = 3;      //количество попыток

            System.out.print("Попробуйте угадать число от 0 до 9 с трёх попыток." + "\n" + "Введите число с помощью клавиатуры: ");

            while (z > 0 && y != x) {
                y = scanner.nextInt();
                if (y == x) {
                    System.out.println("\n" + "Вы угадали! Количество попыток: " + (4 - z) + "! Ещё раз?");
                    System.out.print("Нажмите 1, чтобы начать сначала, 0 - чтобы завершить программу: ");
                    break;
                } else {
                    z--;
                    if (z == 0) {
                        System.out.println("\n" + "Попыток не осталось. их 0. Вы не угадали. Ещё раз?");
                        System.out.print("Нажмите 1, чтобы начать сначала, 0 - чтобы завершить программу: ");
                        break;
                    }
                    if (y > x)
                        System.out.print("\n" + "Вы ввели число больше загаданного. ");
                    else {
                        System.out.print("\n" + "Вы ввели число меньше загаданного. ");
                    }
                    System.out.println("Попробуйте ещё раз, осталось попыток: " + z);
                    System.out.print("Введите новое число с помощью клавиатуры: ");
                }
            }
        } while (scanner.nextInt() == 1);
    }
}






