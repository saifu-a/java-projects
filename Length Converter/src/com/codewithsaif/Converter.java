package com.codewithsaif;

import java.awt.event.*;
import javax.swing.*;

public class Converter implements ActionListener {

    JFrame frame;
    JComboBox<String> cmbUnit1;
    JComboBox<String> cmbUnit2;
    JTextField txtUnit1;
    JTextField txtUnit2;
    JButton btnConvert;

    final String[] lengthUnits = {
            "Millimeter", "Centimeter", "Meter", "Inch",
            "Foot", "Kilometer", "Mile", "Yard"
    };

    public Converter() {
        frame = new JFrame("Length Converter");


        cmbUnit1 = new JComboBox<>(lengthUnits);
        cmbUnit1.setBounds(30, 30, 150, 40);
        frame.add(cmbUnit1);

        cmbUnit2 = new JComboBox<>(lengthUnits);
        cmbUnit2.setBounds(30, 110, 150, 40);
        frame.add(cmbUnit2);

        txtUnit1 = new JTextField();
        txtUnit1.setBounds(200, 30, 150, 40);
        frame.add(txtUnit1);

        txtUnit2 = new JTextField();
        txtUnit2.setBounds(200, 110, 150, 40);
        frame.add(txtUnit2);

        btnConvert = new JButton("Convert");
        btnConvert.setBounds(140, 250, 100, 40);
        btnConvert.addActionListener(this);
        frame.add(btnConvert);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        final double[][] CO_EFF = {
                {1, 0.1, 0.0001, 0.0393701, 0.00328084, 1e-6, 6.2137e-7, 0.00109361},
                {10, 1, 0.01, 0.393701, 0.0328084, 1e-5, 6.2137e-6, 0.0109361},
                {1000, 100, 1, 39.3701, 3.28084, 0.001, 0.000621371, 1.09361},
                {25.4, 2.54, 0.0254, 1, 0.0833333, 2.54e-5, 1.5783e-5, 0.0277778},
                {304.8, 30.48, 0.3048, 12, 1, 0.0003048, 0.000189394, 0.333333},
                {1e+6, 100000, 1000, 39370.1, 3280.84, 1, 0.621371, 1093.61},
                {1.609e+6, 160934, 1609.34, 63360, 5280, 1.60934, 1, 1760},
                {914.4, 91.44, 0.9144, 36, 3, 0.0009144, 0.000568182, 1}
        };
        int unit1 = cmbUnit1.getSelectedIndex();
        int unit2 = cmbUnit2.getSelectedIndex();
        double input = Double.parseDouble(txtUnit1.getText());

        if(event.getSource() == btnConvert) {
            txtUnit2.setText(Double.toString(input * CO_EFF[unit1][unit2]));
        }

    }
}
