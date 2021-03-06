package com.funtolearn.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.funtolearn.daoImp.StoreInfoDaoImp;
import com.funtolearn.main.DBConnection;
import com.funtolearn.util.SettingMenu;

public class MainGui extends JFrame implements ActionListener {

	JButton enroll, exit;
	Border thickBorder = new LineBorder(Color.decode("#44619D"), 10);
	Border thickBorder1 = new LineBorder(Color.decode("#3B1900"), 15);

	Font textsize = new Font("Arial", Font.BOLD, 14);
	JLabel lbl_image = new JLabel(new ImageIcon("images/back.jpg"));
	Font font = new Font("TimesRoman", Font.BOLD, 20);
	Font font1 = new Font("TimesRoman", Font.BOLD, 15);
	Font font2 = new Font("ZapfDingbats", Font.BOLD, 30);
	// Menu option

	JMenuBar menubar = new JMenuBar();
	JMenu menuFile = new JMenu("File");
	JMenu menuHelp = new JMenu("Help");

	private JMenuItem item_Character = new JMenuItem();
	// sub menu

	// sub menu

	private JMenuItem item_Location = new JMenuItem();
	private JMenuItem item_About = new JMenuItem();
	SettingMenu settings = new SettingMenu();

	// Button for the store

	private JButton btn_home = new JButton("Home");
	private JButton btn_save = new JButton("Save");
	private JButton btn_restore = new JButton("Restore");
	private JButton btn_cancel = new JButton("Cancel");
	private JButton btn_Progress = new JButton("Progress");

	private JLabel lbl_selectitem = new JLabel();

	String str_character = "YOU HAVE SELECTED CHARACTER";
	String str_location = "YOU HAVE SELECTED LOCATON";

	// Button for the store

	private JTextArea txt_area = new JTextArea();
	private JCheckBox che_box1 = new JCheckBox();
	private JCheckBox che_box2 = new JCheckBox();
	private JCheckBox che_box3 = new JCheckBox();
	private JCheckBox che_box4 = new JCheckBox();
	ButtonGroup group = new ButtonGroup();

	JLabel lbl_storytitel = new JLabel("No Story Available ");
	JLabel lbl_storycount = new JLabel("0");
	JPanel pan1 = new JPanel();

	//

	//

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static final Dimension PREFERREDSIZE = new Dimension(1200, 650);
	static JFrame frame = new MainGui();

	// 10 button
	private JButton btn_1 = new JButton("1");
	private JButton btn_2 = new JButton("2");
	private JButton btn_3 = new JButton("3");
	private JButton btn_4 = new JButton("4");
	private JButton btn_5 = new JButton("5");
	private JButton btn_6 = new JButton("6");
	private JButton btn_7 = new JButton("7");
	private JButton btn_8 = new JButton("8");
	private JButton btn_9 = new JButton("9");
	private JButton btn_10 = new JButton("10");
	// 10 button
	// character show

	JPanel pan_story = new JPanel();
	JButton btn_back = new JButton("Home");
	JButton story_char1 = new JButton("Story 1");
	JButton story_char2 = new JButton("Story 2");

	JButton story_location1 = new JButton("Story 1");
	JButton story_location2 = new JButton("Story 2");

	//
	String mod1_character = "Ch Story_1   Modules";
	String mod2_character = "Ch Story_2   Modules";

	String mod1_location = "Lo Story_1   Modules";
	String mod2_location = "Lo Story_2   Modules";

	Random rand = new Random();
	StoreInfoDaoImp infoimp = new StoreInfoDaoImp();

	JLabel lbl_modules = new JLabel();

	public static int module_count = 0;
	private JButton btn_finish = new JButton("Finish");
	JLabel lbl_1 = new JLabel("A)");
	JLabel lbl_2 = new JLabel("B)");
	JLabel lbl_3 = new JLabel("C)");
	JLabel lbl_4 = new JLabel("D)");
	//

	public MainGui() {
		super("Story Exploration Game");
		this.create_layout();
		this.CreateJMenuBar();
		this.show_second();
		this.show_characterstory();
		this.show_locationstory();

	}

	public static void createAndShowGUI() {
		try {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setMinimumSize(PREFERREDSIZE);
			frame.setPreferredSize(PREFERREDSIZE);
			frame.setResizable(false);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.pack();
			frame.getContentPane().setBackground(Color.decode("#351500"));
			frame.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error createGui" + ex.toString());
		}

	}

	public static void disposeall() {
		frame.setVisible(false);
	}

	protected void CreateJMenuBar() {
		try {

			menuFile.add(settings.setJMenuItem(item_Character, "Character", "images/g.png"));
			item_Character.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
			item_Character.addActionListener(this);
			item_Character.setMnemonic((int) 'C');

			menuFile.add(settings.setJMenuItem(item_Location, "Location", "images/g.png"));
			item_Location.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
			item_Location.setMnemonic((int) 'L');
			item_Location.addActionListener(this);
			menuFile.addSeparator();

			menuHelp.addSeparator();

			menuHelp.add(settings.setJMenuItem(item_About, "About", "images/help.png"));
			item_About.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
			item_About.addActionListener(this);
			menuHelp.setMnemonic((int) 'H');
			menubar.add(settings.setJMenu(menuFile));
			menubar.add(settings.setJMenu(menuHelp));
			this.setJMenuBar(menubar);
		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, "Error the Manubar" + ex2.toString());

		}

	}

	public void create_layout() {
		try {
			lbl_image.setBackground(Color.red);
			lbl_image.setBounds(10, 10, 1172, 580);
			enroll = new JButton(
					"<html><center><h3>Welcome Story Explation Game</h3></br><h3>Please Chose Option from Menubar</h3></center></html>");
			enroll.setBackground(Color.decode("#351401"));
			enroll.setForeground(Color.white);
			enroll.setBorder(thickBorder);
			enroll.setFont(textsize);
			enroll.setBounds(370, 100, 450, 203);

			exit = new JButton("Exit");
			exit.setBackground(Color.decode("#351500"));
			exit.setForeground(Color.white);
			// exit.setBorder(thickBorder);
			exit.setFont(textsize);
			exit.setBounds(370, 350, 450, 60);
			this.add(exit);

			this.add(enroll);

			this.add(lbl_image);
			enroll.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

				}

			});

			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					@SuppressWarnings("unused")
					int i = JOptionPane.showConfirmDialog(null, "Do you want to Exit?");
					if (i == 0) {
						dispose();
					}
				}
			});

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error createLayout" + ex.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object object = event.getSource();
		int n = rand.nextInt(10) + 1;
		String gettype = lbl_modules.getText().toString();
		String query = null;

		if (object.equals(item_Character)) {
			close_frist();
			lbl_selectitem.setText(str_character);
			// fill_data();
			show_character();

		} else if (object.equals(item_Location)) {
			close_frist();
			lbl_selectitem.setText(str_location);

			// fill_Location();
			show_location();

		} else if (object.equals(btn_home)) {
			faceconformation();

		} else if (object.equals(btn_restore)) {
			try {
				faceconformation();
				infoimp.delete_playerInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (object.equals(btn_cancel)) {
			clickable_storyFalse();
		} else if (object.equals(btn_save)) {
			int assain_value = module_count;
			String st_convert = Integer.toString(assain_value);
			userInfo enroll = new userInfo(this, lbl_modules.getText().toString(), st_convert);
		} else if (object.equals(btn_Progress)) {
			UserProgress progress = new UserProgress(this);
		} else if (object.equals(item_About)) {
			About about = new About(this);
		} else if (che_box1.isSelected() == true) {

			if (gettype.equals("Ch Story_1   Modules")) {

				query = "select * from st_character where ch_track ='" + n + "'";

			} else if (gettype.equals("Ch Story_2   Modules")) {

				query = "select * from st_character1 where ch1_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_1   Modules")) {

				query = "select * from st_location where lo_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_2   Modules")) {

				query = "select * from st_location1 where lo1_track ='" + n + "'";
			}

			access_option(query);

		} else if (che_box2.isSelected() == true) {
			if (gettype.equals("Ch Story_1   Modules")) {

				query = "select * from st_character where ch_track ='" + n + "'";

			} else if (gettype.equals("Ch Story_2   Modules")) {

				query = "select * from st_character1 where ch1_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_1   Modules")) {

				query = "select * from st_location where lo_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_2   Modules")) {

				query = "select * from st_location1 where lo1_track ='" + n + "'";
			}

			access_option(query);

		} else if (che_box3.isSelected() == true) {

			if (gettype.equals("Ch Story_1   Modules")) {

				query = "select * from st_character where ch_track ='" + n + "'";

			} else if (gettype.equals("Ch Story_2   Modules")) {

				query = "select * from st_character1 where ch1_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_1   Modules")) {

				query = "select * from st_location where lo_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_2   Modules")) {

				query = "select * from st_location1 where lo1_track ='" + n + "'";
			}

			access_option(query);

		} else if (che_box4.isSelected() == true) {

			if (gettype.equals("Ch Story_1   Modules")) {

				query = "select * from st_character where ch_track ='" + n + "'";

			} else if (gettype.equals("Ch Story_2   Modules")) {

				query = "select * from st_character1 where ch1_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_1   Modules")) {

				query = "select * from st_location where lo_track ='" + n + "'";

			} else if (gettype.equals("Lo Story_2   Modules")) {

				query = "select * from st_location1 where lo1_track ='" + n + "'";
			}

			access_option(query);

		} else if (object.equals(btn_back)) {
			Open_frist();
		} else if (object.equals(story_char1)) {
			//

			lbl_modules.setText(mod1_character);
			clickable_storyTrue();
			String query1 = "select * from st_character where ch_id ='" + n + "'";
			fill_data(query1);

		} else if (object.equals(story_char2)) {

			lbl_modules.setText(mod2_character);
			clickable_storyTrue();
			String query2 = "select * from st_character1 where ch1_id ='" + n + "'";
			fill_data(query2);
		} else if (object.equals(story_location1)) {

			lbl_modules.setText(mod1_location);
			clickable_storyTrue();
			String query3 = "select * from st_location where lo_id ='" + n + "'";
			fill_data(query3);

		} else if (object.equals(story_location2)) {

			lbl_modules.setText(mod2_location);
			clickable_storyTrue();
			String query3 = "select * from st_location1 where lo1_id ='" + n + "'";
			fill_data(query3);

		} else if (object.equals(btn_finish)) {
			create_togglebartrue();
		}

	}

	public void close_frist() {
		enroll.setVisible(false);
		exit.setVisible(false);
		pan_story.setVisible(true);
		btn_back.setVisible(true);
		lbl_selectitem.setVisible(true);
		story_char1.setVisible(true);
		story_char2.setVisible(true);

	}

	public void Open_frist() {
		enroll.setVisible(true);
		exit.setVisible(true);
		pan1.setVisible(false);
		btn_home.setVisible(false);
		btn_save.setVisible(false);
		btn_restore.setVisible(false);
		btn_cancel.setVisible(false);
		btn_Progress.setVisible(false);
		lbl_selectitem.setVisible(false);
		pan_story.setVisible(false);
		btn_back.setVisible(false);
	}

	public void show_second() {

		try {

			pan1.setLayout(null);
			pan1.setBounds(130, 170, 870, 385);
			pan1.setBackground(Color.decode("#BE920D"));
			pan1.setForeground(Color.white);

			pan1.setBorder(thickBorder1);
			pan1.setVisible(false);

			txt_area.setBounds(40, 100, 810, 130);
			txt_area.setFont(font);
			// txt_area.setBackground(Color.WHITE);
			txt_area.setBackground(Color.decode("#BE920D"));
			txt_area.setForeground(Color.WHITE);
			// add to group

			group.add(che_box1);
			group.add(che_box2);
			group.add(che_box3);
			group.add(che_box4);
			che_box1.addActionListener(this);
			che_box2.addActionListener(this);
			che_box3.addActionListener(this);
			che_box4.addActionListener(this);
			btn_finish.addActionListener(this);
			// add to group

			btn_finish.setBounds(42, 240, 80, 25);
			btn_finish.setForeground(Color.WHITE);
			btn_finish.setBackground(Color.decode("#351500"));

			che_box1.setBounds(140, 250, 330, 25);
			lbl_1.setBounds(120, 250, 20, 25);
			lbl_1.setFont(font1);

			che_box2.setBounds(500, 250, 330, 25);
			lbl_2.setBounds(480, 250, 20, 25);
			lbl_2.setFont(font1);
			che_box3.setBounds(140, 320, 330, 25);
			lbl_3.setBounds(120, 320, 20, 25);
			lbl_3.setFont(font1);
			che_box4.setBounds(500, 320, 330, 25);
			lbl_4.setBounds(480, 320, 20, 25);
			lbl_4.setFont(font1);

			che_box1.setFont(font1);
			che_box2.setFont(font1);
			che_box3.setFont(font1);
			che_box4.setFont(font1);
			btn_finish.setFont(font1);

			che_box1.setBackground(Color.decode("#BE920D"));
			che_box2.setBackground(Color.decode("#BE920D"));
			che_box3.setBackground(Color.decode("#BE920D"));
			che_box4.setBackground(Color.decode("#BE920D"));

			che_box1.setForeground(Color.WHITE);
			che_box2.setForeground(Color.WHITE);
			che_box3.setForeground(Color.WHITE);
			che_box4.setForeground(Color.WHITE);

			lbl_1.setForeground(Color.WHITE);
			lbl_2.setForeground(Color.WHITE);
			lbl_3.setForeground(Color.WHITE);
			lbl_4.setForeground(Color.WHITE);

			// ssss

			lbl_modules.setBounds(30, 30, 250, 45);
			lbl_modules.setFont(font);
			lbl_modules.setForeground(Color.decode("#3B1900"));

			btn_1.setBounds(220, 30, 45, 45);
			btn_1.setBackground(Color.decode("#3A1800"));
			btn_1.setForeground(Color.WHITE);
			btn_1.setFont(font1);

			btn_2.setBounds(270, 30, 45, 45);
			btn_2.setBackground(Color.decode("#3A1800"));
			btn_2.setForeground(Color.WHITE);
			btn_2.setFont(font1);

			btn_3.setBounds(320, 30, 45, 45);
			btn_3.setBackground(Color.decode("#3A1800"));
			btn_3.setForeground(Color.WHITE);
			btn_3.setFont(font1);

			btn_4.setBounds(370, 30, 45, 45);
			btn_4.setBackground(Color.decode("#3A1800"));
			btn_4.setForeground(Color.WHITE);
			btn_4.setFont(font1);

			btn_5.setBounds(420, 30, 45, 45);
			btn_5.setBackground(Color.decode("#3A1800"));
			btn_5.setForeground(Color.WHITE);
			btn_5.setFont(font1);

			//

			btn_6.setBounds(470, 30, 45, 45);
			btn_6.setBackground(Color.decode("#3A1800"));
			btn_6.setForeground(Color.WHITE);
			btn_6.setFont(font1);

			btn_7.setBounds(520, 30, 45, 45);
			btn_7.setBackground(Color.decode("#3A1800"));
			btn_7.setForeground(Color.WHITE);
			btn_7.setFont(font1);

			btn_8.setBounds(570, 30, 45, 45);
			btn_8.setBackground(Color.decode("#3A1800"));
			btn_8.setForeground(Color.WHITE);
			btn_8.setFont(font1);

			btn_9.setBounds(620, 30, 45, 45);
			btn_9.setBackground(Color.decode("#3A1800"));
			btn_9.setForeground(Color.WHITE);
			btn_9.setFont(font1);

			btn_10.setBounds(670, 30, 45, 45);
			btn_10.setBackground(Color.decode("#3A1800"));
			btn_10.setForeground(Color.WHITE);
			btn_10.setFont(font1);
			Action action = new Action();

			btn_1.addActionListener(action);
			btn_2.addActionListener(action);
			btn_3.addActionListener(action);
			btn_4.addActionListener(action);
			btn_5.addActionListener(action);
			btn_6.addActionListener(action);
			btn_7.addActionListener(action);
			btn_8.addActionListener(action);
			btn_9.addActionListener(action);
			btn_10.addActionListener(action);

			pan1.add(lbl_modules);
			pan1.add(btn_1);
			pan1.add(btn_2);
			pan1.add(btn_3);
			pan1.add(btn_4);
			pan1.add(btn_5);

			pan1.add(btn_6);
			pan1.add(btn_7);
			pan1.add(btn_8);
			pan1.add(btn_9);
			pan1.add(btn_10);

			pan1.add(btn_finish);
			pan1.add(che_box1);
			pan1.add(che_box2);
			pan1.add(che_box3);
			pan1.add(che_box4);
			pan1.add(lbl_1);
			pan1.add(lbl_2);
			pan1.add(lbl_3);
			pan1.add(lbl_4);

			lbl_selectitem.setBounds(330, 10, 550, 60);
			lbl_selectitem.setFont(font2);

			btn_home.setBounds(330, 75, 90, 90);
			btn_save.setBounds(430, 75, 90, 90);
			btn_restore.setBounds(530, 75, 90, 90);
			btn_cancel.setBounds(630, 75, 90, 90);
			btn_Progress.setBounds(730, 75, 90, 90);

			btn_home.setFont(font1);
			btn_save.setFont(font1);
			btn_restore.setFont(font1);
			btn_cancel.setFont(font1);
			btn_Progress.setFont(font1);

			btn_home.setBackground(Color.decode("#00A2FF"));
			btn_save.setBackground(Color.decode("#C134BE"));
			btn_restore.setBackground(Color.decode("#F89B0F"));
			btn_cancel.setBackground(Color.decode("#B631AE"));
			btn_Progress.setBackground(Color.decode("#FED88D"));
			btn_home.setForeground(Color.WHITE);
			btn_restore.setForeground(Color.WHITE);
			btn_cancel.setForeground(Color.WHITE);
			btn_save.setForeground(Color.WHITE);
			btn_Progress.setForeground(Color.WHITE);
			btn_home.addActionListener(this);
			btn_restore.addActionListener(this);
			btn_cancel.addActionListener(this);
			btn_save.addActionListener(this);
			btn_Progress.addActionListener(this);
			// we can delcare the visable false

			btn_home.setVisible(false);
			btn_save.setVisible(false);
			btn_restore.setVisible(false);
			btn_cancel.setVisible(false);
			lbl_selectitem.setVisible(false);
			btn_Progress.setVisible(false);
			// fale the content
			create_togglebarfalse();
			pan1.add(txt_area);
			lbl_image.add(btn_home);
			lbl_image.add(btn_save);
			lbl_image.add(btn_restore);
			lbl_image.add(btn_cancel);
			lbl_image.add(btn_Progress);
			lbl_image.add(lbl_selectitem);
			lbl_image.add(pan1);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

	}

	// show character story

	public void show_characterstory() {
		try {
			pan_story.setBounds(370, 100, 450, 203);
			pan_story.setLayout(null);
			pan_story.setBackground(Color.decode("#351401"));
			pan_story.setForeground(Color.white);

			btn_back.setBackground(Color.decode("#351500"));
			btn_back.setForeground(Color.white);
			btn_back.setFont(textsize);
			btn_back.setBounds(370, 350, 445, 50);

			story_char1.setBounds(80, 50, 110, 110);
			story_char1.setBackground(Color.decode("#029FFC"));
			story_char1.setForeground(Color.WHITE);
			story_char1.setFont(font);

			story_char2.setBounds(240, 50, 110, 110);
			story_char2.setBackground(Color.decode("#FF9C00"));
			story_char2.setForeground(Color.WHITE);
			story_char2.setFont(font);

			btn_back.addActionListener(this);
			story_char1.addActionListener(this);
			story_char2.addActionListener(this);

			btn_back.setVisible(false);
			story_char1.setVisible(false);
			story_char2.setVisible(false);
			pan_story.setVisible(false);

			pan_story.add(story_char1);
			pan_story.add(story_char2);
			lbl_image.add(pan_story);
			lbl_image.add(btn_back);

			storybuttontrue();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error character" + ex.toString());
		}
	}

	// show location story
	public void show_locationstory() {
		try {
			story_location1.setBounds(80, 50, 110, 110);
			story_location1.setBackground(Color.decode("#029FFC"));
			story_location1.setForeground(Color.WHITE);
			story_location1.setFont(font);
			story_location2.setBounds(240, 50, 110, 110);
			story_location2.setBackground(Color.decode("#FF9C00"));
			story_location2.setForeground(Color.WHITE);
			story_location2.setFont(font);

			story_location1.addActionListener(this);
			story_location2.addActionListener(this);

			pan_story.setVisible(false);
			story_location1.setVisible(false);
			story_location2.setVisible(false);
			pan_story.add(story_location1);
			pan_story.add(story_location2);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public void storybuttontrue() {

		pan_story.setVisible(true);

	}
	//

	public void fill_data(String query) {
		Connection con = null;
		try {
			con = DBConnection.getConnecttion();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error" + e.toString());
		}
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			clearfield();
			while (rs.next()) {
				String str_1 = rs.getString(2);
				String str_2 = rs.getString(3);
				String str_3 = rs.getString(4);
				String str_4 = rs.getString(5);
				String str_5 = rs.getString(6);
				txt_area.setText(str_1);
				che_box1.setText(str_2);
				che_box2.setText(str_3);
				che_box3.setText(str_4);
				che_box4.setText(str_5);
			}
			con.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error" + ex.toString());
		}

	}
	// second paragraph

	public void fill_Location() {
		Connection con = null;
		try {
			con = DBConnection.getConnecttion();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error" + e.toString());
		}
		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM location";
			ResultSet rs = stmt.executeQuery(query);
			clearfield();
			while (rs.next()) {
				String str_1 = rs.getString("location_story");
				String str_2 = rs.getString("location_a");
				String str_3 = rs.getString("location_b");
				String str_4 = rs.getString("location_c");
				String str_5 = rs.getString("location_d");
				txt_area.setText(str_1);
				che_box1.setText(str_2);
				che_box2.setText(str_3);
				che_box3.setText(str_4);
				che_box4.setText(str_5);
			}
			con.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error" + ex.toString());
		}

	}

	public void access_option(String data) {

		Connection con = null;
		try {
			con = DBConnection.getConnecttion();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error" + e.toString());
		}
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(data);
			clearfield();
			while (rs.next()) {
				String str_1 = rs.getString(2);
				String str_2 = rs.getString(3);
				String str_3 = rs.getString(4);
				String str_4 = rs.getString(5);
				String str_5 = rs.getString(6);
				module_count++;
				txt_area.setText(str_1);
				che_box1.setText(str_2);
				che_box2.setText(str_3);
				che_box3.setText(str_4);
				che_box4.setText(str_5);
				group.clearSelection();

			}
			con.close();
			create_togglebarfalse();
			if (module_count >= 10) {

				int i = JOptionPane.showConfirmDialog(null, "You have already complete 10 " + "\n" + " of "
						+ lbl_modules.getText().toString() + "\n" + "Please Choose Another Story!!!");
				if (i == 1) {
					clickable_storyFalse();
				}

				// JOptionPane.showMessageDialog(null, "You have already complete 10 " + "\n" +
				// " of "
				// + lbl_modules.getText().toString() + "\n" + "Please Choose Another
				// Story!!!");

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error" + ex.toString());
		}
	}

	public void clearfield() {
		txt_area.setText("");
		che_box1.setText("");
		che_box2.setText("");
		che_box3.setText("");
		che_box4.setText("");

	}

	public void faceconformation() {
		int j = JOptionPane.showConfirmDialog(null, "Do you want to save Your Game??");
		if (j == 1) {
			Open_frist();
		}
	}

	public void show_character() {
		btn_back.setVisible(true);
		story_char1.setVisible(true);
		story_char2.setVisible(true);
		pan_story.setVisible(true);
		story_location1.setVisible(false);
		story_location2.setVisible(false);

	}

	public void show_location() {
		story_location1.setVisible(true);
		story_location2.setVisible(true);
		pan_story.setVisible(true);
		story_char1.setVisible(false);
		story_char2.setVisible(false);

	}

	public void clickable_storyTrue() {
		module_count = 0;
		pan1.setVisible(true);
		btn_home.setVisible(true);
		btn_save.setVisible(true);
		btn_restore.setVisible(true);
		btn_cancel.setVisible(true);
		btn_Progress.setVisible(true);
		lbl_selectitem.setVisible(true);
		pan_story.setVisible(false);
		btn_back.setVisible(false);
	}

	public void clickable_storyFalse() {
		module_count = 0;
		pan1.setVisible(false);
		btn_home.setVisible(false);
		btn_save.setVisible(false);
		btn_restore.setVisible(false);
		btn_cancel.setVisible(false);
		btn_Progress.setVisible(false);
		lbl_selectitem.setVisible(true);
		pan_story.setVisible(true);
		btn_back.setVisible(true);
	}

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			String query = null;
			String gettype = lbl_modules.getText().toString();
			if (source.equals(btn_1)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 1 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 1 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 1 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 1 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_2)) {

				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 2 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 2 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 2 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 2 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_3)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 3 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 3 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 3 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 3 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_4)) {

				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 4 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 4 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 4 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 4 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_5)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 5 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 5 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 5 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 5 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_6)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 6 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 6 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 6 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 6 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_7)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 7 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 7 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 7 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 7 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_8)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 8 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 8 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 8 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 8 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_9)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 9 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 9 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 9 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 9 + "'";
				}
				sequencebysearch(query);
			} else if (source.equals(btn_10)) {
				if (gettype.equals("Ch Story_1   Modules")) {
					query = "select * from st_character where ch_id ='" + 10 + "'";
				} else if (gettype.equals("Ch Story_2   Modules")) {
					query = "select * from st_character1 where ch1_id ='" + 10 + "'";
				} else if (gettype.equals("Lo Story_1   Modules")) {
					query = "select * from st_location where lo_id ='" + 10 + "'";
				} else if (gettype.equals("Lo Story_2   Modules")) {
					query = "select * from st_location1 where lo1_id ='" + 10 + "'";
				}
				sequencebysearch(query);
			}

		}

		public void sequencebysearch(String query) {
			Connection con = null;
			try {
				con = DBConnection.getConnecttion();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error" + e.toString());
			}
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				clearfield();
				while (rs.next()) {
					String str_1 = rs.getString(2);
					String str_2 = rs.getString(3);
					String str_3 = rs.getString(4);
					String str_4 = rs.getString(5);
					String str_5 = rs.getString(6);

					txt_area.setText(str_1);
					che_box1.setText(str_2);
					che_box2.setText(str_3);
					che_box3.setText(str_4);
					che_box4.setText(str_5);
				}
				con.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error" + ex.toString());
			}
		}

	}

	public void create_togglebartrue() {
		che_box1.setVisible(true);
		che_box2.setVisible(true);
		che_box3.setVisible(true);
		che_box4.setVisible(true);
		lbl_1.setVisible(true);
		lbl_2.setVisible(true);
		lbl_3.setVisible(true);
		lbl_4.setVisible(true);

		btn_finish.setVisible(false);
	}

	public void create_togglebarfalse() {
		che_box1.setVisible(false);
		che_box2.setVisible(false);
		che_box3.setVisible(false);
		che_box4.setVisible(false);

		lbl_1.setVisible(false);
		lbl_2.setVisible(false);
		lbl_3.setVisible(false);
		lbl_4.setVisible(false);

		btn_finish.setVisible(true);
	}

}
