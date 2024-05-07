import java.util.Scanner;

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
                    break;
                case "2":
                    EliminateWord();
                    break;

                default:
                    break;
            }
        }

    }

    public static void AddWord() {
        JOptionPane.showInputDialog(null, "introduzca la palabra");
        String wordToAdd = KEYBOARD.nextLine();
        qualifier.addWord(wordToAdd);
        JOptionPane.showMessageDialog(null, "la palabra se ha agregado correctamente");
    }

    public static void EliminateWord() {
        JOptionPane.showInputDialog(null, "ingrese la palabara para eliminarla");
        String wordToDelete = KEYBOARD.nextLine();
        if (qualifier.getWordByInitial().values().removeIf(list -> list.contains(wordToDelete))) {
            JOptionPane.showMessageDialog(null, "Palabra eliminada correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "La palabra no estaba almacenada");
        }
    }
}
