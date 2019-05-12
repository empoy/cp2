package com.sampoytech.shopaholic;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI {

	private JFrame frame;
	private JTable seller;
	private JTable product;
	UserConnection uc;
	ArrayList<User> user;
	String address;
	ProductConnection pc;
	ArrayList<Product> productAr;
	String selectedID;
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
		
		uc=new UserConnection();
		user=uc.lister();
		
		
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
		
		JLabel txtNumber = new JLabel("");
		txtNumber.setBounds(154, 115, 92, 26);
		frame.getContentPane().add(txtNumber);
		
		JButton btnShowInMap = new JButton("Show In Map");
		btnShowInMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				URI uri;
				try {
					uri = new URI(address);
					open(uri);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnShowInMap.setBounds(154, 64, 177, 35);
		frame.getContentPane().add(btnShowInMap);
		sellerTableFill();
		
seller.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				selectedID=(String) seller.getValueAt(seller.getSelectedRow(),0);
				try {
					productTableFill();
				} catch (IOException | ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					User selected=uc.select(selectedID);
					txtName.setText(selected.getName());
					txtNumber.setText(selected.getNumber());
					address=selected.getAddress();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	}
	
	public void sellerTableFill() throws IOException
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
	
	public void productTableFill() throws IOException, ParseException
	{
		pc=new ProductConnection(selectedID);
		productAr=pc.lister();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Price");
		
		for (int i = 0; i < productAr.size(); i++) 
		{
			Vector<Object> row = new Vector<Object>(productAr.size());
			row.add(productAr.get(i).getId());
			row.add(productAr.get(i).getName());
			row.add(productAr.get(i).getPrice());
			model.addRow(row);
		}
		
		product.setModel(model);
		//table.setRowSelectionInterval(0, 0);
	}
	
	protected void open(URI uri) {
		// TODO Auto-generated method stub
		if (Desktop.isDesktopSupported()) {
		      try {
		        Desktop.getDesktop().browse(uri);
		      } catch (IOException e) { }
		    } else {  }
	}

}
