package CODIGO.VIEWS.EVENTOS;

import CODIGO.VIEWS.Ventanas.Areas.AreaVisual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;

public class EventoCambiarPanel implements ActionListener {

    String name;


    public  EventoCambiarPanel(String name){
        this.name = name;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        AreaVisual.panelRegistros.removeAll();
        AreaVisual.panelRegistros.setBackground(Color.red);
        AreaVisual.panelRegistros.AgregarRegistrosPanel(AreaVisual.panelRegistros, this.name);
        System.out.println("nombre es :" +name);
    }
}
