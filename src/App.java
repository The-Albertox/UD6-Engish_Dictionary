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
        while (exist) {
            option = menu.getMenu();
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
                    ShowByInitial();
                    break;

                case "5":
                    ShowWordByInitial();
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Hasta la proxima");
                    exist = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "error opcion incorrecta");
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

    public static void ShowByInitial() {
        JOptionPane.showInputDialog(null, " mostrar iniciales disponibles");
        Set<Character> initials = qualifier.getInitials();
        for (char initial : initials) {
            JOptionPane.showMessageDialog(null, initial);
        }
    }

    public static void ShowWordByInitial() {
        char initialToShow = JOptionPane.showInputDialog(null, "ingrese una inicial").charAt(0);
        List<String> wordsByInitial = qualifier.getWordsByInitial(initialToShow);
        if (wordsByInitial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "no se ha encontrado la palabra");
        } else {
            JOptionPane.showMessageDialog(null, ("Palabras que comienzan con " + initialToShow + ":"));
            for (String word : wordsByInitial) {
                JOptionPane.showMessageDialog(null, word);
            }
        }

    }

}
