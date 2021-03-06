package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BasicFrame extends JFrame {
	private JLabel textLabel;
	private JTextField textField;
	private JButton button;
	private JPanel panel;
	private JPanel basicPanel;
	private Dialog dialog;
	private static final int DEFAULT_WIDTH = 1280;
	private static final int DEFAULT_HEIGHT = 720;
	
	public BasicFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("������������α׷� Ver1.0.0_201721070 ��ȿ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public JPanel makeBasicPanel() {
		basicPanel = new JPanel();
		basicPanel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		basicPanel.setLayout(new GridLayout(3, 1));
		return basicPanel;
	}

	public JLabel makeLabel(String text, int fontSize) {

		textLabel = new JLabel(text, JLabel.CENTER);
		textLabel.setFont(new Font("���� ����", Font.BOLD, fontSize));

		return textLabel;
	}
	
	public JTextField makeTextField(String text, int columnSize, int fontSize, ActionListener listener) {
		textField = new JTextField(text, columnSize);
		textField.setFont(new Font("���� ����", Font.BOLD, fontSize));
		textField.addActionListener(listener);
		
		return textField;
	}
	
	
	public JButton makeButton(String text, int fontSize, ActionListener listener) {
		button = new JButton(text);
		button.setFont(new Font("���� ����", Font.BOLD, fontSize));
		button.addActionListener(listener);
		return button;
	}
	
	public JPanel makePanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		return panel;
	}

	public Dialog makeDialog() {
		dialog = new Dialog(this, "Information", true);
		dialog.setLayout(new BorderLayout());
		dialog.setSize(400,150);
		return dialog;
	}
}
