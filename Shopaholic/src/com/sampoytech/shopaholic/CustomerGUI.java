package com.sampoytech.shopaholic;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class CustomerGUI {

	private JFrame frame;
	private JTable seller;
	private JTable product;
	UserConnection uc;
	ArrayList<User> user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI window = new CustomerGUI();
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
	public CustomerGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		seller = new JTable();
		seller.setBounds(41, 273, 315, 308);
		frame.getContentPane().add(seller);
		
		product = new JTable();
		product.setBounds(414, 273, 418, 308);
		frame.getContentPane().add(product);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 21, 92, 26);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(41, 68, 92, 26);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(41, 115, 92, 26);
		frame.getContentPane().add(lblNumber);
		
		JLabel txtName = new JLabel("");
		txtName.setBounds(154, 21, 92, 26);
		frame.getContentPane().add(txtName);
		
		JLabel txtAddress = new JLabel("");
		txtAddress.setBounds(154, 68, 92, 26);
		frame.getContentPane().add(txtAddress);
		
		JLabel txtNumber = new JLabel("");
		txtNumber.setBounds(154, 115, 92, 26);
		frame.getContentPane().add(txtNumber);
		tableFill();
	}
	
	public void tableFill() throws IOException
	{
		uc=new UserConnection();
		user=uc.lister();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("surname");
		
		
		for (int i = 0; i < user.size(); i++) 
		{
			if(user.get(i).getAccessLevel().equals("2"))
			{
			Vector<Object> row = new Vector<Object>(user.size());
			row.add(user.get(i).getId());
			row.add(user.get(i).getName());
			row.add(user.get(i).getSurname());
			model.addRow(row);
			}
		}
		
		seller.setModel(model);
		//seller.setRowSelectionInterval(0, 0);
	}

}
