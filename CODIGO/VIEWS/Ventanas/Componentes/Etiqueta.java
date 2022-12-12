package CODIGO.VIEWS.Ventanas.Componentes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Etiqueta  extends JLabel {
    Font newFont = new Font("Serif", Font.BOLD, 22);
    Border border = BorderFactory.createLineBorder(Color.ORANGE);
    public  Etiqueta(String nombre){
        super(nombre);
        setOpaque(true);

        setBackground(Color.cyan);
        setFont(newFont);
        setForeground(new Color(120, 90, 40));


        setBorder(border);
    }

}
