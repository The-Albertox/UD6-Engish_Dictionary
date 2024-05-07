package app.salesianos.resource;

import javax.swing.JOptionPane;

public class Menu {
    public String getMenu() {
        String Menu = """
                Menu de opciones:
                1. Añiadir palabra.
                2. Eliminar palabra.
                3.Existe palabra.
                4. Mostar iniciales disponibles.
                5. Ver palabras por inicial.
                6. Cerrar programa
                """;
        return JOptionPane.showInputDialog(null, Menu, Menu, JOptionPane.INFORMATION_MESSAGE);
    }
}
