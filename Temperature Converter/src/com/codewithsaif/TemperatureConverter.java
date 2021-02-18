package com.codewithsaif;

import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter implements ActionListener {

    JFrame frame;
    JRadioButton radCelsius;
    JRadioButton radFahrenheit;
    ButtonGroup buttonGroup;
    JLabel lblCelsius;
    JLabel lblFahrenheit;
    JTextField txtCelsius;
    JTextField txtFahrenheit;
    JButton btnConvert;

    public TemperatureConverter() {
        frame = new JFrame("Temperature Converter");
        buttonGroup = new ButtonGroup();
        
        radCelsius = new JRadioButton();
        radCelsius.setBounds(25, 55, 20, 20);
        radCelsius.setSelected(true);
        radCelsius.addActionListener(this);
        buttonGroup.add(radCelsius);
        frame.add(radCelsius);
        
        radFahrenheit = new JRadioButton();
        radFahrenheit.setBounds(25, 105, 20, 20);
        radFahrenheit.addActionListener(this);
        buttonGroup.add(radFahrenheit);
        frame.add(radFahrenheit);

        lblCelsius = new JLabel("Celsius");
        lblCelsius.setBounds(50, 50, 150, 30);
        frame.add(lblCelsius);

        lblFahrenheit = new JLabel("Fahrenheit");
        lblFahrenheit.setBounds(50, 100, 150, 30);
        frame.add(lblFahrenheit);

        txtCelsius = new JTextField();
        txtCelsius.setBounds(150, 50, 150, 30);
        frame.add(txtCelsius);

        txtFahrenheit = new JTextField();
        txtFahrenheit.setBounds(150, 100, 150, 30);
        frame.add(txtFahrenheit);

        btnConvert = new JButton("Convert");
        btnConvert.setBounds(150, 225, 100, 30);
        btnConvert.addActionListener(this);
        frame.add(btnConvert);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        double tempCelsius;
        double tempFahrenheit;

        if(radCelsius.isSelected()) {
            if (event.getSource() == btnConvert) {
                final double CO_EFF = 1.8;
                final double OFFSET = 32;

                try {
                    tempCelsius = Double.parseDouble(txtCelsius.getText());
                    tempFahrenheit = CO_EFF * tempCelsius + OFFSET;
                    txtFahrenheit.setText(Double.toString(tempFahrenheit));
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Enter input!");
                }
            }
        }

        if(radFahrenheit.isSelected()) {
            if (event.getSource() == btnConvert) {
                final double CO_EFF = (double) 5 / 9;
                final double OFFSET = 32;

                try {
                    tempFahrenheit = Double.parseDouble(txtFahrenheit.getText());
                    tempCelsius = CO_EFF * (tempFahrenheit - OFFSET);
                    txtCelsius.setText(Double.toString(tempCelsius));
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Enter input!");
                }
            }
        }
    }
}
