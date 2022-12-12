package CODIGO.VIEWS.Ventanas.Areas;

import CODIGO.VIEWS.EVENTOS.EventoCambiarPanel;
import CODIGO.VIEWS.Ventanas.Componentes.Boton;
import CODIGO.VIEWS.Ventanas.Paneles.MainPanel;

import javax.swing.*;
import java.awt.*;

public class AreaVisual extends JPanel {

    public static MainPanel panelRegistros;

    static int ancho, alto;

    JButton[] listaBotones = {
            new Boton("Inicio"),
            new Boton("Categorias"),
            new Boton("Clientes") ,
            new Boton("Detalle Venta"),
            new Boton("Documentos"),
            new Boton("Productos"),
            new Boton("Proveedores"),
            new Boton("Tipos Cliente"),
            new Boton("Usuarios"),
            new Boton("Ventas"),
            new Boton("Zonas"),
    };

    public  AreaVisual(int ancho, int alto){
        this.ancho  = ancho;
        this .alto  =alto;
        setLayout(null);
        setBounds(0,0,ancho, alto);
        setBackground(Color.green);

        panelRegistros = new MainPanel(350,100,ancho - 400,alto-200, Color.cyan);

        add(panelRegistros);

        crearPanelBotones(this);
    }

    public void crearPanelBotones(JPanel panel){
        int lugar= 50;
        for (int i =0; i < listaBotones.length ; i++){
            listaBotones[i].setBounds(30,lugar,300,50);
            panel.add(listaBotones[i]);
            listaBotones[i].addActionListener(new EventoCambiarPanel(listaBotones[i].getText()));
            lugar = lugar + 60;
        }
    }

    public static void crearPanelRegistros(Color new_color ){
        panelRegistros.setBackground(Color.red);
       // panelLocal.add(nuevoPanel);
    }

}
