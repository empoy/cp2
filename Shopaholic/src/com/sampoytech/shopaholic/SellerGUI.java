package com.sampoytech.shopaholic;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

public class SellerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static String log;
	public static void main(String[] args,String logId) {
		log=logId;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerGUI window = new SellerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public SellerGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 919, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 21, 92, 26);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(21, 60, 92, 26);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(327, 60, 92, 26);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(327, 21, 92, 26);
		frame.getContentPane().add(lblNumber);
		
		JLabel nameTxt = new JLabel("");
		nameTxt.setBounds(134, 21, 92, 26);
		frame.getContentPane().add(nameTxt);
		
		JLabel surnameTxt = new JLabel("");
		surnameTxt.setBounds(134, 60, 92, 26);
		frame.getContentPane().add(surnameTxt);
		
		JLabel numberTxt = new JLabel("");
		numberTxt.setBounds(440, 21, 92, 26);
		frame.getContentPane().add(numberTxt);
		
		JLabel addressTxt = new JLabel("");
		addressTxt.setBounds(440, 60, 92, 26);
		frame.getContentPane().add(addressTxt);
		
		UserConnection uc=new UserConnection();
		User u=uc.userSelect(log);
		nameTxt.setText(u.getName());
		surnameTxt.setText(u.getSurname());
		numberTxt.setText(u.getNumber());
		addressTxt.setText(u.getAddress());
		
	}
}
