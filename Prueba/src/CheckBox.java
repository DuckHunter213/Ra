import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gerar
 */
public class CheckBox {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        //Aquí armas el ArrayList de los contenidos, yo setee cada uno
        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.add("Contenido 1");
        myArrayList.add("Contenido 2");
        myArrayList.add("Contenido 3");
        myArrayList.add("Contenido 4");
        myArrayList.add("Contenido 5");
        myArrayList.add("Contenido 6");
        myArrayList.add("Contenido 7");
        myArrayList.add("Contenido 8");
        myArrayList.add("Contenido 9");
        myArrayList.add("Contenido 10");
        myArrayList.add("Contenido 11");
        myArrayList.add("Contenido 12");
        myArrayList.add("Contenido 13");

        JPanel panel = new JPanel();
        //Aquí pones el checkbox de manera vertical
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //La lista de Checkboxes se declara aquí
        List<JCheckBox> checkboxes = new ArrayList<>();

        //Aquí, por cada elemento de "mis contenidos", agregó un checkbox y le añado el contenido
        for (String element : myArrayList) {
            JCheckBox box = new JCheckBox(element);
            checkboxes.add(box);
            panel.add(box);
        }
        //Recorrí los checkbox para seleccionar los número pares y simular la selección del usuario
        int i = 0;
        for (JCheckBox checkbox : checkboxes) {
            if (i % 2 == 2) {
                checkbox.setSelected(true);
            }
            i += 1;
        }
        
        //Aquí recorro los checkbox y en lugar de guardar el contenido del checkbox, guardo ArrayList de Integer
        i = 0;
        ArrayList<Integer> seleccionados = new ArrayList<>();
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                seleccionados.add(i);
            }
            i += 1;
        }
        
        //Aquí imprimo en pantalla los contenidos para verificar que sean adecuados
        seleccionados.stream().forEach((seleccionado) -> {
            System.out.println(seleccionado);
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
