package CODIGO.VIEWS.Ventanas.Componentes;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {

    Font fuenteBoton = new Font("Helvetica", Font.PLAIN, 18);


    public  Boton(String nombre){
        super(nombre);
        setBackground(Color.yellow);
        setFont(fuenteBoton);
    }

}
