package com.conversores;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.clases.Divisa;
import com.clases.Temperatura;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ConversorTemperatura extends JInternalFrame {
	private JTextField ctTemperaturaConvertida;
	private JComboBox cbTemperaturaInicial;
	private JTextField ctTemperaturaInicial;
	private JComboBox cbTemperaturaFinal;
	private JLabel img1;
	private JLabel img2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorTemperatura() {
		getContentPane().setBackground(new Color(211, 211, 211));
		setClosable(true);
		setTitle("Conversor de Temperatura");
		setBounds(100, 100, 316, 300);
		getContentPane().setLayout(null);
		
		cbTemperaturaInicial = new JComboBox();
		cbTemperaturaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = (String) cbTemperaturaInicial.getSelectedItem();
				switch (p) {
					case "°C - Grados Centigrados":
						img1.setText("°C");
						break;
					case "°F - Grados Fahrenheit":
						img1.setText("°F");
						break;
					case "K - Kelvin":
						img1.setText("K");
						break;
				}
			}
		});
		cbTemperaturaInicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbTemperaturaInicial.setModel(new DefaultComboBoxModel(new String[] {"°C - Grados Centigrados", "°F - Grados Fahrenheit", "K - Kelvin"}));
		cbTemperaturaInicial.setBounds(46, 92, 207, 22);
		getContentPane().add(cbTemperaturaInicial);
		
		JLabel eTexto = new JLabel("Ingresa Temperatura:");
		eTexto.setFont(new Font("Tahoma", Font.BOLD, 15));
		eTexto.setBounds(46, 35, 207, 27);
		getContentPane().add(eTexto);
		
		ctTemperaturaConvertida = new JTextField();
		ctTemperaturaConvertida.setFont(new Font("Tahoma", Font.BOLD, 15));
		ctTemperaturaConvertida.setHorizontalAlignment(SwingConstants.CENTER);
		ctTemperaturaConvertida.setBounds(46, 195, 207, 27);
		getContentPane().add(ctTemperaturaConvertida);
		ctTemperaturaConvertida.setColumns(10);
		
		ctTemperaturaInicial = new JTextField();
		ctTemperaturaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		ctTemperaturaInicial.setFont(new Font("Tahoma", Font.BOLD, 15));
		ctTemperaturaInicial.setColumns(10);
		ctTemperaturaInicial.setBounds(46, 62, 207, 27);
		getContentPane().add(ctTemperaturaInicial);
		
		img2 = new JLabel("");
		img2.setFont(new Font("Tahoma", Font.BOLD, 22));
		img2.setHorizontalAlignment(SwingConstants.CENTER);
		img2.setBounds(182, 125, 60, 31);
		getContentPane().add(img2);
		
		img1 = new JLabel("");
		img1.setFont(new Font("Tahoma", Font.BOLD, 22));
		img1.setHorizontalAlignment(SwingConstants.CENTER);
		img1.setBounds(56, 125, 60, 31);
		getContentPane().add(img1);
		
		JLabel lbl = new JLabel(">>>");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(126, 125, 46, 31);
		getContentPane().add(lbl);
		
		JLabel eTitulo = new JLabel("CONVERSOR DE TEMPERATURA");
		eTitulo.setForeground(new Color(255, 0, 0));
		eTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		eTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		eTitulo.setBounds(15, 0, 274, 34);
		getContentPane().add(eTitulo);
		
		cbTemperaturaFinal = new JComboBox();
		cbTemperaturaFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r = (String) cbTemperaturaFinal.getSelectedItem();
				switch (r) {
					case "°C - Grados Centigrados":
						img2.setText("°C");
						break;
					case "°F - Grados Fahrenheit":
						img2.setText("°F");
						break;
					case "K - Kelvin":
						img2.setText("K");
						break;
				}
			}
		});
		cbTemperaturaFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbTemperaturaFinal.setModel(new DefaultComboBoxModel(new String[] {"°F - Grados Fahrenheit", "K - Kelvin", "°C - Grados Centigrados"}));
		cbTemperaturaFinal.setBounds(46, 167, 207, 22);
		getContentPane().add(cbTemperaturaFinal);
		
		JButton btnNewButton = new JButton("CONVERTIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					convertir();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(desktopIcon, "Error! Ingrese un valor correcto");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(98, 233, 108, 31);
		getContentPane().add(btnNewButton);

	}
	
	public void convertir() {
		//Declaro las divisas
		ArrayList<Temperatura> listaTemperatura = new ArrayList<>();
		Temperatura C = new Temperatura("°C - Grados Centigrados", 1);
		Temperatura F = new Temperatura("°F - Grados Fahrenheit", 1);
		Temperatura K = new Temperatura("K - Kelvin", 1);
		double n = 0;
		listaTemperatura.add(C);
		listaTemperatura.add(F);
		listaTemperatura.add(K);
		DecimalFormat decimal = new DecimalFormat("##.##");
		
		//Operaciones
		if (cbTemperaturaInicial.getSelectedItem() == "°C - Grados Centigrados" && cbTemperaturaFinal.getSelectedItem() == "°F - Grados Fahrenheit") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText())*1.8)+32;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() == "°F - Grados Fahrenheit" && cbTemperaturaFinal.getSelectedItem() == "°C - Grados Centigrados") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText())-32)/1.8;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() == "°F - Grados Fahrenheit" && cbTemperaturaFinal.getSelectedItem() == "K - Kelvin") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText())-32)*5/9+273.15;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() == "°C - Grados Centigrados" && cbTemperaturaFinal.getSelectedItem() == "K - Kelvin") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText()))+273.15;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() == "K - Kelvin" && cbTemperaturaFinal.getSelectedItem() == "°C - Grados Centigrados") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText()))-273.15;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() == "K - Kelvin" && cbTemperaturaFinal.getSelectedItem() == "°F - Grados Fahrenheit") {
			n = (Double.parseDouble(ctTemperaturaInicial.getText())-273.15)*9/5+32;
			ctTemperaturaConvertida.setText(String.valueOf(decimal.format(n)));
		}
		if (cbTemperaturaInicial.getSelectedItem() ==  cbTemperaturaFinal.getSelectedItem()) {
			ctTemperaturaConvertida.setText(ctTemperaturaInicial.getText());
		}
		
	}
	
}
