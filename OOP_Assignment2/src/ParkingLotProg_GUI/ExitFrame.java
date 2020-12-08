package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ParkingProgram.Car;
import ParkingProgram.Test;

public class ExitFrame extends BasicFrame {

	private JPanel exitMainPanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = makePanel();
	private JPanel inputPanel = makePanel();
	private JLabel alertLabel = makeLabel("", 15);
	private JPanel boxPanel = new JPanel();
	private String carNum;
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");
	private Dialog infoDialog;

	public ExitFrame() {
		super();
//		paintedCarNumPanel();
		infoDialog = makeDialog();
		infoDialog.add(alertLabel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(makeButton("Ȯ��", 15, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoDialog.setVisible(false);
			}
		}));
		infoDialog.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void paintedCarNumPanel() {

		exitMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		inputPanel.removeAll();
		boxPanel.removeAll();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("2�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("������ ���ϴ� ���� ��ȣ�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(4�ڸ� ����)", 25));

		JTextField inputField = makeTextField("Ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					JTextField t = (JTextField) e.getSource();
					carNum = t.getText();

					if (carNum.length() != 4) {
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					}
					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
						}
					}
					if (Test.checkParkingLot(carNum) == -1) {

						throw new IllegalArgumentException("���� : �Է��� ������ �����忡 �������� �ʽ��ϴ�.");
					}
					paintedDatePanel(carNum);

				} catch (InputMismatchException e1) {
					alertLabel.setText("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					infoDialog.setVisible(true);
				} catch (IllegalArgumentException e1) {
					alertLabel.setText("���� : �Է��� ������ �����忡 �������� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					carNum = inputField.getText();

					if (carNum.length() != 4) {
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					}
					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
						}
					}
					if (Test.checkParkingLot(carNum) == -1) {

						throw new IllegalArgumentException("���� : �Է��� ������ �����忡 �������� �ʽ��ϴ�.");
					}

					paintedDatePanel(carNum);
				} catch (InputMismatchException e1) {
					alertLabel.setText("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					infoDialog.setVisible(true);
				} catch (IllegalArgumentException e1) {
					alertLabel.setText("���� : �Է��� ������ �����忡 �������� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
				}
			}
		}));

		inputPanel.add(boxPanel);
		exitMainPanel.add(titlePanel);
		exitMainPanel.add(contentPanel);
		exitMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(exitMainPanel);
		revalidate();
		repaint();
	}

	public void paintedDatePanel(String carNum) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		boxPanel.removeAll();

		contentPanel.add(makeLabel("������ ������ȣ�� " + carNum + "�Դϴ�.", 35));

		boxPanel.add(makeLabel("���� �ð��� �Է����ּ���.", 25));
		boxPanel.add(makeLabel("(�� �� �� �� ��)", 25));

		JTextField inputField = makeTextField("Ex) 2020 12 20 8 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String entryTime = t.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("���� : ��¥ �Է��� �ùٸ��� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
					e1.printStackTrace();
				}
				// �����ð� �����ɶ� �ͼ���
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String entryTime = inputField.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("���� : ��¥ �Է��� �ùٸ��� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
					e1.printStackTrace();
				}
			}
		}));

		inputPanel.add(boxPanel);
		exitMainPanel.add(contentPanel);
		exitMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(exitMainPanel);
		revalidate();
		repaint();
	}

	public void paintedCheckPanel() {
		inputPanel.removeAll();
		contentPanel.removeAll();

		contentPanel.setLayout(new FlowLayout());
		inputPanel.setLayout(new FlowLayout());

		String exitValue = Test.runExit(carNum, entryDate);
		String processedValue[] = exitValue.split(" ");

		contentPanel.add(makeLabel("�����ð��� " + processedValue[0] + "�ð� " + processedValue[1] + "���Դϴ�.", 35));
		contentPanel.add(makeLabel("��������� " + processedValue[2] + "���Դϴ�.", 35));
		inputPanel.add(makeLabel("������ �Ϸ�Ǿ����ϴ�.", 25));

		inputPanel.add(makeButton("�ʱ�ȭ��", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		}));

		exitMainPanel.add(contentPanel);
		exitMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(exitMainPanel);
		revalidate();
		repaint();
	}

}