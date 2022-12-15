package Sixthwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Firsttask {
    public static void main(String[] args) {
        NoteBooks Notebook1 = new NoteBooks("MSI", "6", "512", "Windows", "grey");
        NoteBooks Notebook2 = new NoteBooks("Asus", "4", "256", "Linux", "black");
        NoteBooks Notebook3 = new NoteBooks("Acer", "8", "750", "Windows", "black");
        NoteBooks Notebook4 = new NoteBooks("Acer", "16", "1000", "Windows", "grey");
        NoteBooks Notebook5 = new NoteBooks("MacBook", "8", "512", "MacOS", "space grey");

        Set<NoteBooks> Notebooks = new HashSet<>(List.of(Notebook1, Notebook2,
                Notebook3, Notebook4, Notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, Notebooks);

    }

    public static String scanner() {
        try (Scanner scanner = new Scanner(System.in)) {
            String scan = scanner.nextLine();
            return scan;
        }
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out.println("Вы хотите использовать фильтр? Если да введите 'y', если нет введите 'n'");
            String question = scanner();
            if (question.equals("n")) {
                break;
            } else {

                System.out.println(
                        "Введите цифру, соответствующую необходимому фильтру: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем жесткого диска \n 4 - Операционная система \n 5 - Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного фильтра: ");
                String value = scanner();

                resultCriterias.put(key, value);
            }
        }
        System.out.println(resultCriterias);
        return resultCriterias;

    }

    public static void sort(Map<String, String> criterias, Set<NoteBooks> Notebooks) {

        Set<NoteBooks> temp = new HashSet<>(Notebooks);
        for (NoteBooks Notebook : Notebooks) {

            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !Notebook.getName().equals(criterias.get(pair))) {
                    temp.remove(Notebook);
                }
                for (Object pair1 : criterias.keySet()) {

                    if (pair1.equals("2") && !Notebook.getRam().equals(criterias.get(pair1))) {
                        temp.remove(Notebook);

                    }
                    for (Object pair2 : criterias.keySet()) {

                        if (pair2.equals("3") && !Notebook.getHardDisk().equals(criterias.get(pair2))) {
                            temp.remove(Notebook);

                        }
                        for (Object pair3 : criterias.keySet()) {

                            if (pair3.equals("4") && !Notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                                temp.remove(Notebook);

                            }
                            for (Object pair4 : criterias.keySet()) {

                                if (pair4.equals("5") && !Notebook.getColour().equals(criterias.get(pair4))) {
                                    temp.remove(Notebook);

                                }
                            }
                        }
                    }
                }
            }

        }
        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp.toString());
        }

    }

}
