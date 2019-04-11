package com.funtolearn.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameSetting extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox check_On, check_off;
	Font font = new Font("TimesRoman", Font.BOLD, 15);

	public GameSetting(JFrame parent) {
		super(JOptionPane.getFrameForComponent(parent), "Sound Setting", true);
		this.createEnrollpanel();
	}

	public void createEnrollpanel() {
		try {
			this.setSize(400, 200);
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			check_On = new JCheckBox("ON");
			check_off = new JCheckBox("OFF");
			check_On.setBounds(130, 40, 210, 30);
			check_off.setBounds(130, 80, 210, 30);
			check_On.addActionListener(this);
			check_off.addActionListener(this);
			check_On.setBackground(Color.decode("#BE9700"));
			check_off.setBackground(Color.decode("#BE9700"));
			check_On.setFont(font);
			check_off.setFont(font);
			this.add(check_On);
			this.add(check_off);
			this.getContentPane().setBackground(Color.decode("#BE9700"));
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Occure Enrollpane" + ex.toString());

		}
	}

	public void setting_On() {
		try {
			if (check_On.isSelected() == true) {
				JOptionPane.showMessageDialog(null, "Access!!!");
			} else {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!!");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}
	}

	public void setting_Off() {
		try {
			if (check_off.isSelected() == true) {
				JOptionPane.showMessageDialog(null, "Access!!!");
			} else {
				JOptionPane.showMessageDialog(null, "Field Must Not Empty!!!");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(check_On)) {
			setting_On();
		} else if (source.equals(check_off)) {
			setting_Off();
		}

	}
}