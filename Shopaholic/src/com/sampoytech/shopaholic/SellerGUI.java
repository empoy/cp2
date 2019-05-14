package com.sampoytech.shopaholic;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerGUI {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	static String log;
	private JTable table;
	
	ProductConnection pc;
	ArrayList<Product> product;
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
	 * @throws ParseException 
	 */
	public SellerGUI() throws IOException, ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private void initialize() throws IOException, ParseException {
		File f=new File(log+".txt");
		if (f.exists()!=true)
		{
			PrintWriter pw=new PrintWriter(new FileWriter(f),true);
			pw.close();
		}
		
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
		
		Connection uc=new UserConnection();
		User u=(User) uc.select(log);
		nameTxt.setText(u.getName());
		surnameTxt.setText(u.getSurname());
		numberTxt.setText(u.getNumber());
		addressTxt.setText(u.getAddress());
		
		table = new JTable();
		table.setBounds(43, 196, 813, 419);
		frame.getContentPane().add(table);
		tableFill();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ProductAdder.main(null, log);
			}
		});
		btnAdd.setBounds(107, 151, 141, 35);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String deleteID=JOptionPane.showInputDialog(frame, "Enter ID");
				
				try {
					pc=new ProductConnection(log);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if(pc.delete(deleteID))
					{
						JOptionPane.showMessageDialog(null, "Successfully Deleted");
					}
					else
						JOptionPane.showMessageDialog(null, "Delete Unsuccessful");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SellerGUI.main(null, log);
			}
		});
		btnDelete.setBounds(440, 151, 141, 35);
		frame.getContentPane().add(btnDelete);
		
	}
	
	public void tableFill() throws IOException, ParseException
	{
		pc=new ProductConnection(log);
		product=pc.lister();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Price");
		
		for (int i = 0; i < product.size(); i++) 
		{
			Vector<Object> row = new Vector<Object>(product.size());
			row.add(product.get(i).getId());
			row.add(product.get(i).getName());
			row.add(product.get(i).getPrice());
			model.addRow(row);
		}
		
		table.setModel(model);
		//table.setRowSelectionInterval(0, 0);
	}
	
}
