package Zona2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZonaGUI {
    private JFrame frame;
    private JTextField idZonaField;
    private JTextField distritoField;
    private JTextField disponibilidadField;
    private JTextField areaField;
    private JTextField poblacionField;
    private ArrayList<Zona> zonas;

    public ZonaGUI() {
        zonas = new ArrayList<>();
        frame = new JFrame("Formulario de Zona");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los campos de texto y etiquetas
        JLabel idZonaLabel = new JLabel("Id Zona:");
        idZonaField = new JTextField(5);
        JLabel distritoLabel = new JLabel("Distrito:");
        distritoField = new JTextField(20);
        JLabel disponibilidadLabel = new JLabel("Disponibilidad:");
        disponibilidadField = new JTextField(1);
        JLabel areaLabel = new JLabel("Área:");
        areaField = new JTextField(7);
        JLabel poblacionLabel = new JLabel("Población:");
        poblacionField = new JTextField(5);

        // Botón de guardar
        JButton guardarButton = new JButton("Guardar");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar los campos antes de guardar
                String idZona = idZonaField.getText().trim();
                String distrito = distritoField.getText().trim();
                String disponibilidadText = disponibilidadField.getText().trim();
                String areaText = areaField.getText().trim();
                String poblacionText = poblacionField.getText().trim();

                if (idZona.isEmpty() || idZona.length() > 5) {
                    JOptionPane.showMessageDialog(frame, "El IdZona debe ser no vacío y tener una longitud máxima de 5 caracteres.");
                    return;
                }

                if (distrito.isEmpty() || distrito.length() > 30) {
                    JOptionPane.showMessageDialog(frame, "El Distrito debe ser no vacío y tener una longitud máxima de 30 caracteres.");
                    return;
                }

                if (disponibilidadText.isEmpty() || disponibilidadText.length() != 1 || !("SN".contains(disponibilidadText))) {
                    JOptionPane.showMessageDialog(frame, "La Disponibilidad debe ser 'S' o 'N'.");
                    return;
                }

                char disponibilidad = disponibilidadText.charAt(0);

                double area;
                try {
                    area = Double.parseDouble(areaText);
                    if (area <= 0) {
                        JOptionPane.showMessageDialog(frame, "El área debe ser un número positivo.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "El área debe ser un número decimal válido.");
                    return;
                }

                int poblacion;
                try {
                    poblacion = Integer.parseInt(poblacionText);
                    if (poblacion <= 0) {
                        JOptionPane.showMessageDialog(frame, "La población debe ser un número entero positivo.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La población debe ser un número entero válido.");
                    return;
                }

                // Crear la zona y agregarla a la lista
                Zona zona = new Zona(idZona, distrito, disponibilidad, area, poblacion);
                zonas.add(zona);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(frame, "Zona guardada correctamente.");
                
                // Limpiar los campos de texto
                idZonaField.setText("");
                distritoField.setText("");
                disponibilidadField.setText("");
                areaField.setText("");
                poblacionField.setText("");
            }
        });

        // Agregar componentes al frame
        frame.add(idZonaLabel);
        frame.add(idZonaField);
        frame.add(distritoLabel);
        frame.add(distritoField);
        frame.add(disponibilidadLabel);
        frame.add(disponibilidadField);
        frame.add(areaLabel);
        frame.add(areaField);
        frame.add(poblacionLabel);
        frame.add(poblacionField);
        frame.add(guardarButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ZonaGUI();
    }
}
