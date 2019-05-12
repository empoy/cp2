package com.sampoytech.shopaholic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class ProductAdder {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	static String ID;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args,String id) {
		ID=id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdder window = new ProductAdder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductAdder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(21, 21, 92, 26);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 68, 92, 26);
		frame.getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(21, 115, 92, 26);
		frame.getContentPane().add(lblPrice);
		
		txtID = new JTextField();
		txtID.setBounds(134, 21, 186, 32);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(134, 65, 186, 32);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(134, 112, 186, 32);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductConnection pc=new ProductConnection(ID);
					Product p=new Product();
					p.setId(txtID.getText());
					p.setName(txtName.getText());
					p.setPrice(Integer.parseInt( txtPrice.getText()));
					pc.adderProduct(p);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnSave.setBounds(160, 173, 141, 35);
		frame.getContentPane().add(btnSave);
	}

}
