/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */

package FifthHomework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Firsttask {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Lena", List.of("8 926 333 33 33", "8 926 222 22 99"));
        phoneBook.put("Ira", List.of("8 926 333 33 55", "8 926 222 22 00"));
        phoneBook.put("Igor", List.of("8 926 333 33 66", "8 926 222 22 44"));
        phoneBook.put("Petr", List.of("8 926 333 33 77", "8 926 222 22 11"));
        phoneBook.put("Dima", List.of("8 926 333 33 88", "8 926 222 22 22"));

        menu(phoneBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phoneBook) {
        System.out.println("Если хотите выйте хотите перестать вводить номера введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phoneBook.put(name, number);

        return phoneBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phoneBook);
                        break;
                    case "add":
                        add(phoneBook);
                        break;
                    case "all":
                        allBook(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}
