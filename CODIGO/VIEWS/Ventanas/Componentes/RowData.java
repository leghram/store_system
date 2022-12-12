package CODIGO.VIEWS.Ventanas.Componentes;

import javax.swing.*;
import java.awt.*;

public class RowData extends JPanel {

    int anchoDisponible;

    int tamanoElement;

    public RowData(String[] listElements, int inicioY, int anchoX){
        super();
        this.anchoDisponible = anchoX;
        setLayout(null);
        setBounds(0,inicioY,anchoX,40);
        putElements(listElements, this);
    }

    public void putElements(String[] listData, JPanel panelRowData){
        tamanoElement = this.anchoDisponible/ (listData.length+ 2);

        int posicionx = 0;
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Delete");
        for(int a =0; a < listData.length ; a ++){
            Etiqueta nuevaTag = new Etiqueta(listData[a]);

            panelRowData.add(nuevaTag);

            nuevaTag.setBounds(posicionx,0,tamanoElement,40);
            posicionx = posicionx + tamanoElement;
        }

        panelRowData.add(btnEditar);
        panelRowData.add(btnEliminar);
        btnEditar.setBackground(Color.green);
        btnEditar.setBounds(posicionx,0,tamanoElement,60);
        posicionx = posicionx + tamanoElement;
        btnEliminar.setBounds(posicionx,0,tamanoElement,40);

    }




}
