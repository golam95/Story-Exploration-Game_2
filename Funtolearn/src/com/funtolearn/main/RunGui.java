package com.funtolearn.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.funtolearn.view.MainGui;

public class RunGui {

	public static void main(String[] arg) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			MainGui.createAndShowGUI();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
