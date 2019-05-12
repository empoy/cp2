package com.sampoytech.shopaholic;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserAdder {

	private JFrame frame;
	static String Log;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtNumber;
	private JTextField txtAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String log) {
		Log=log;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAdder window = new UserAdder();
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
	public UserAdder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 609);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 597, 610);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(56, 13, 22, 26);
		frame.getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(181, 10, 186, 32);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(56, 73, 94, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(58, 136, 92, 26);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(56, 199, 92, 26);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(56, 267, 92, 26);
		frame.getContentPane().add(lblSurname);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(181, 70, 186, 32);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(181, 133, 186, 32);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(181, 196, 186, 32);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(181, 264, 186, 32);
		frame.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SuperUser", "Seller", "Customer"}));
		comboBox.setBounds(181, 334, 186, 32);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAccessLevel = new JLabel("Access Level");
		lblAccessLevel.setBounds(56, 337, 116, 26);
		frame.getContentPane().add(lblAccessLevel);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(56, 391, 92, 26);
		frame.getContentPane().add(lblNumber);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(181, 388, 186, 32);
		frame.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(56, 438, 92, 26);
		frame.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(181, 435, 186, 32);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				frame.dispose();
				//File file=new File("Login.txt");
				int i=comboBox.getSelectedIndex();
				
				User u=new User(txtID.getText(),txtUsername.getText(),txtPassword.getText(),txtName.getText(),
						txtSurname.getText(),String.valueOf(comboBox.getSelectedIndex()+1),txtNumber.getText(),txtAddress.getText());
				
				switch (i) {
				case 0:
					try {
						UserConnection uc=new UserConnection();
						if (uc.adderUser(u))
						{
							JOptionPane.showMessageDialog(null, "Successfully Added");
							txtID.setText("");
							txtUsername.setText("");
							txtPassword.setText("");
							txtName.setText("");
							txtSurname.setText("");
							txtNumber.setText("");
							txtAddress.setText("");
							try {
								SuperuserGUI s=new SuperuserGUI();
								s.main(null, Log);
								
								
							} catch (URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						else 
							JOptionPane.showMessageDialog(null, "Adding was unsuccessful");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
				case 1:
					
					
					
					
					try {
						UserConnection uc=new UserConnection();
						if (uc.adderUser(u))
						{
							JOptionPane.showMessageDialog(null, "Successfully Added");
							txtID.setText("");
							txtUsername.setText("");
							txtPassword.setText("");
							txtName.setText("");
							txtSurname.setText("");
							txtNumber.setText("");
							txtAddress.setText("");
							try {
								SuperuserGUI s=new SuperuserGUI();
								s.main(null, Log);
							} catch (URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else 
							JOptionPane.showMessageDialog(null, "Adding was unsuccessful");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
				case 2:
					try {
						UserConnection uc=new UserConnection();
						if (uc.adderUser(u))
						{
							JOptionPane.showMessageDialog(null, "Successfully Added");
							txtID.setText("");
							txtUsername.setText("");
							txtPassword.setText("");
							txtName.setText("");
							txtSurname.setText("");
							txtNumber.setText("");
							txtAddress.setText("");
							try {
								SuperuserGUI s=new SuperuserGUI();
								s.main(null, Log);
								frame.dispose();
							} catch (URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else 
							JOptionPane.showMessageDialog(null, "Adding was unsuccessful");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;

				default:
					break;
				}
				
			}
			
		});
		btnSave.setBounds(409, 483, 141, 35);
		frame.getContentPane().add(btnSave);
	}

}
