package CODIGO.VIEWS.Ventanas;


import CODIGO.VIEWS.Ventanas.Areas.AreaVisual;
import CODIGO.VIEWS.Ventanas.Paneles.MainPanel;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    AreaVisual panelpro;

    Toolkit datosPantalla;
    Dimension dimensionesPantalla;
    int anchoPantalla, altoPantalla;

    public VentanaPrincipal(){
        datosPantalla = Toolkit.getDefaultToolkit();
        dimensionesPantalla = datosPantalla.getScreenSize();
        anchoPantalla = dimensionesPantalla.width;
        altoPantalla = dimensionesPantalla.height;

        panelpro = new AreaVisual(anchoPantalla, altoPantalla);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,anchoPantalla,altoPantalla);
        setVisible(true);

        add(panelpro);

    }

}
