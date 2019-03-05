package com.sampoytech.shopaholic;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class SuperuserGUI {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtNumber;
	private JTextField txtHyper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperuserGUI window = new SuperuserGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws URISyntaxException 
	 */
	public SuperuserGUI() throws URISyntaxException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws URISyntaxException 
	 */
	private void initialize() throws URISyntaxException {
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(21, 21, 315, 487);
		frame.getContentPane().add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(632, 266, 141, 35);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(632, 322, 141, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
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
		
		JComboBox AccCombo = new JComboBox();
		AccCombo.setMaximumRowCount(3);
		AccCombo.setBounds(710, 19, 186, 32);
		frame.getContentPane().add(AccCombo);
		
		JButton btnHyperLink = new JButton("");
		btnHyperLink.setText("<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>"
		        + " to go to the Google Map.</HTML>");
		btnHyperLink.setBorderPainted(false);
	    btnHyperLink.setOpaque(false);
	    URI uri = new URI("http://java.sun.com");
	    
		btnHyperLink.addActionListener(new ActionListener() {
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
