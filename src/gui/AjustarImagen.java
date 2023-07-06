package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * La clase AjustarImagen proporciona un método para ajustar una imagen a un botón.
 */
public class AjustarImagen {

    /**
     * Ajusta una imagen al tamaño del botón especificado.
     *
     * @param button     El botón al que se ajustará la imagen.
     * @param rutaImagen La ruta de la imagen a ajustar.
     */
    public void AjustaImagen(JButton button, String rutaImagen) {

        ImageIcon ico = new ImageIcon(getClass().getResource(rutaImagen));
        ImageIcon img = new ImageIcon(
                ico.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));

        button.setIcon(img);

    }

}
