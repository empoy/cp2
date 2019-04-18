package com.sampoytech.shopaholic;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class SuperuserGUI {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtNumber;
	private JTextField txtHyper;
	private JTable table;
	static String log;
	
	UserConnection uc=new UserConnection();
	ArrayList<User> user=uc.listerUser();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String log1) 
	{
		log=log1;
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SuperuserGUI window = new SuperuserGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public SuperuserGUI() throws URISyntaxException, IOException {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	private void initialize() throws URISyntaxException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(632, 266, 141, 35);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setBounds(632, 322, 141, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Boolean delete;
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete UserId"+txtId.getText()+"?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION) 
				{
					try {
						if (uc.delete(txtId.getText()))
						{
							JOptionPane.showMessageDialog(null, "Successfully Deleted");
							user=uc.listerUser();
							tableFill();
							
						}
						else
							JOptionPane.showMessageDialog(null, "Delete Failed");
					} catch (HeadlessException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnDelete.setBounds(632, 378, 141, 35);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(357, 160, 92, 26);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurname.setBounds(357, 210, 92, 26);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAccesLevel = new JLabel("Acces Level");
		lblAccesLevel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesLevel.setBounds(632, 25, 92, 26);
		frame.getContentPane().add(lblAccesLevel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(357, 25, 92, 26);
		frame.getContentPane().add(lblId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(357, 66, 92, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(357, 113, 92, 26);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumber.setBounds(632, 66, 92, 26);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(632, 113, 92, 26);
		frame.getContentPane().add(lblAddress);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(425, 19, 186, 32);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(425, 60, 186, 32);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(425, 107, 186, 32);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(425, 154, 186, 32);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(425, 204, 186, 32);
		frame.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(710, 60, 186, 32);
		frame.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		JComboBox<Object> AccCombo = new JComboBox<Object>();
		AccCombo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Super User", "Seller", "Customer"}));
		AccCombo.setMaximumRowCount(3);
		AccCombo.setBounds(710, 19, 186, 32);
		frame.getContentPane().add(AccCombo);
		
		JButton btnHyperLink = new JButton("");
		btnHyperLink.setText("<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>"
		        + " to go to the Google Map.</HTML>");
		btnHyperLink.setBorderPainted(false);
	    btnHyperLink.setOpaque(false);
	    URI uri = new URI("http://java.sun.com");
	    
		btnHyperLink.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				open(uri);
			}
		});
		btnHyperLink.setBounds(710, 106, 141, 35);
		frame.getContentPane().add(btnHyperLink);
		btnHyperLink.setVisible(false);
		
		
		txtHyper = new JTextField();
		txtHyper.setBounds(710, 107, 186, 32);
		frame.getContentPane().add(txtHyper);
		txtHyper.setColumns(10);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(632, 503, 285, 26);
		frame.getContentPane().add(lblLog);
		lblLog.setText("welcome User:"+log);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(21, 25, 315, 483);
		frame.getContentPane().add(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				txtId.setText(user.get(table.getSelectedRow()).getId());
				txtUsername.setText(user.get(table.getSelectedRow()).getUsername());
				txtPassword.setText(user.get(table.getSelectedRow()).getPassword());
				txtName.setText( user.get(table.getSelectedRow()).getName());
				txtSurname.setText(user.get(table.getSelectedRow()).getSurname());
				txtHyper.setText(user.get(table.getSelectedRow()).getAddress());
				txtNumber.setText(user.get(table.getSelectedRow()).getNumber());
				try {
				AccCombo.setSelectedIndex((Integer.valueOf(user.get(table.getSelectedRow()).getAccessLevel()))-1);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		try {
		tableFill();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				User u=new User();
				u.setId(txtId.getText());
				u.setUsername(txtUsername.getText());
				u.setPassword(txtPassword.getText());
				u.setName(txtName.getText());
				u.setSurname(txtSurname.getText());
				u.setAccessLevel(String.valueOf(AccCombo.getSelectedIndex()+1));
				u.setNumber(txtNumber.getText());
				u.setAddress(txtHyper.getText());
				
				try {
					if(uc.updateUser(u))
					{
						JOptionPane.showMessageDialog(null, "Successfully Updated");
						tableFill();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
	}

	public void tableFill() throws IOException
	{
		uc=new UserConnection();
		user=uc.listerUser();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("surname");
		
		for (int i = 0; i < user.size(); i++) 
		{
			Vector<Object> row = new Vector<Object>(user.size());
			row.add(user.get(i).getId());
			row.add(user.get(i).getName());
			row.add(user.get(i).getSurname());
			model.addRow(row);
		}
		
		table.setModel(model);
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
