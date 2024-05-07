import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import app.salesianos.resource.Menu;
import app.salesianos.wordQualifier.WordQualifier;

public class App {
    static final Scanner KEYBOARD = new Scanner(System.in);
    static final WordQualifier qualifier = new WordQualifier();

    public static void main(String[] args) throws Exception {
        boolean exist = true;
        String option = "";

        Menu menu = new Menu();
        System.out.println("1");
        while (exist) {
            System.out.println("2");
            option = menu.getMenu();
            System.out.println("3");
            switch (option) {

                case "1":
                    AddWord();
                    System.out.println("a");
                    break;
                case "2":
                    EliminateWord();
                    break;

                case "3":
                    ExistWord();
                    break;

                case "4":
                    ShowWordByInitial();
                    break;

                case "6":
                    exist = false;
                    break;

                default:
                    break;
            }
        }

    }

    public static void AddWord() {
        String wordToAdd = JOptionPane.showInputDialog(null, "introduzca la palabra");
        qualifier.addWord(wordToAdd);
        JOptionPane.showMessageDialog(null, "la palabra se ha agregado correctamente");
    }

    public static void EliminateWord() {
        String wordToDelete = JOptionPane.showInputDialog(null, "ingrese la palabara para eliminarla");
        if (qualifier.getWordByInitial().values().removeIf(list -> list.contains(wordToDelete))) {
            JOptionPane.showMessageDialog(null, "Palabra eliminada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "La palabra no estaba almacenada");
        }
    }

    public static void ExistWord() {
        String wordToFind = JOptionPane.showInputDialog(null, "Ponga la palabra que desa buscar");
        boolean exists = false;
        for (List<String> words : qualifier.getWordByInitial().values()) {
            if (words.contains(wordToFind)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            JOptionPane.showMessageDialog(null, "la palabra se ha encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "La palabra no se ha encontrado");
        }
    }

    public static void ShowWordByInitial() {
        JOptionPane.showMessageDialog(null, " mostrar iniciales disponibles");
        Set<Character> initials = qualifier.getInitials();
        for (char initial : initials) {
            JOptionPane.showMessageDialog(null, initial);
        }
    }

}
