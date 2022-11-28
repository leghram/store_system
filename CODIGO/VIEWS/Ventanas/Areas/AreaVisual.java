package CODIGO.VIEWS.Ventanas.Areas;

import CODIGO.VIEWS.Ventanas.Componentes.Boton;
import CODIGO.VIEWS.Ventanas.Paneles.MainPanel;

import javax.swing.*;
import java.awt.*;

public class AreaVisual extends JPanel {

    MainPanel panelRegistros;

    JButton[] listaBotones = {
            new Boton("Inicio"),
            new Boton("Documentos"),
            new Boton("Proveedores") ,
            new Boton("Categorias"),
            new Boton("Productos"),
            new Boton("Ventas"),
            new Boton("Detalle Ventas"),
            new Boton("Clientes"),
            new Boton("Tipo Clientes"),
            new Boton("Zonas"),
            new Boton("Usuarios"),
    };

    public  AreaVisual(int ancho, int alto){
        setLayout(null);
        setBounds(0,0,ancho, alto);
        setBackground(Color.green);



        crearPanelBotones(this);
        crearPanelRegistros(this, panelRegistros, ancho ,alto);
    }

    public void crearPanelBotones(JPanel panel){
        int lugar= 50;
        for (int i =0; i < listaBotones.length ; i++){
            listaBotones[i].setBounds(30,lugar,300,50);
            panel.add(listaBotones[i]);
            lugar = lugar + 60;
        }
    }

    public void crearPanelRegistros(JPanel panelLocal,JPanel nuevoPanel, int ancho , int alto ){
        nuevoPanel= new MainPanel( 350,100,ancho - 400,alto-200);
        panelLocal.add(nuevoPanel);
    }

}
