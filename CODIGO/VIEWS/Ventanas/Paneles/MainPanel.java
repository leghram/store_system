package CODIGO.VIEWS.Ventanas.Paneles;

import CODIGO.VIEWS.Ventanas.Componentes.Boton;
import CODIGO.VIEWS.Ventanas.Componentes.Etiqueta;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    JButton[] listaOpciones = {
            new Boton("Ver Registros"),
            new Boton("Insertar"),
            new Boton("Actualizar"),
            new Boton("Eliminar")
    };

    public  MainPanel(int inicioX, int inicioY, int anchoX, int altoY){
        setLayout(null);
        setBounds(inicioX,inicioY,anchoX,altoY);
        setBackground(Color.cyan);

        generarOpcionesMenu(this, anchoX);

    }


    public void generarOpcionesMenu(JPanel panel, int anchoTotal){
        int posicion= 0;
        int anchoBoton = anchoTotal/4;
        for (int i =0; i < listaOpciones.length ; i++){
            listaOpciones[i].setBounds(posicion,0,anchoBoton,50);
            panel.add(listaOpciones[i]);
            posicion = posicion + anchoBoton;
        }
    }





}
