package conversores;

import gui.MenuPrincipalGui;

/**
 * La clase MenuConversor crea una instancia de la GUI del menú principal y la muestra.
 */
public class MenuConversor {

    /**
     * Crea una instancia de la GUI del menú principal y la muestra.
     */
    public MenuConversor() {
        MenuPrincipalGui menu = new MenuPrincipalGui();
        menu.setVisible(true);
    }

}
