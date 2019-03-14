package com.sampoytech.shopaholic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frmLogin;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(145, 51, 233, 32);
		frmLogin.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(145, 102, 233, 32);
		frmLogin.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(21, 54, 92, 26);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(21, 107, 92, 26);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u=new User();
				u.setUsername(username.getText());
				u.setPassword(password.getText());
				LoginChecker lc=new LoginChecker(u);
				
				String[] a= {};
				try 
				{
					a=lc.check();
					if (a.length==1)
					{
						JOptionPane.showMessageDialog(null, "Username or Password incorrect");
					}
						
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch (a[3]) {
				case "1":
					
						//SuperuserGUI su=new SuperuserGUI(a[1]);
						SuperuserGUI.main(null,a[1]);
					
					break;
				case "2":
					
					break;
				case "3":
					
					break;
				default:
					break;
				}
			}
		});
		btnLogin.setBounds(191, 157, 141, 35);
		frmLogin.getContentPane().add(btnLogin);
	}
}
