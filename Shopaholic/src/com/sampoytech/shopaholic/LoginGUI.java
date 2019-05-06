package com.sampoytech.shopaholic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.Box;

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
		frmLogin.setBounds(100, 100, 463, 352);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel usernamePanel = new JPanel();
		//frmLogin.getContentPane().add(usernamePanel);
		
		JLabel lblUsername = new JLabel("Username:");
		usernamePanel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		username = new JTextField();
		usernamePanel.add(username);
		username.setColumns(15);
		
		Box verticalBox = Box.createVerticalBox();
		frmLogin.getContentPane().add(verticalBox);
		
		verticalBox.add(usernamePanel);
		
		JPanel passwordPanel = new JPanel();
		//frmLogin.getContentPane().add(passwordPanel);
		
		verticalBox.add(passwordPanel);
		
		JLabel lblPassword = new JLabel("Password:");
		passwordPanel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		password = new JPasswordField();
		passwordPanel.add(password);
		password.setColumns(15);
		
		JPanel btnPanel = new JPanel();
		frmLogin.getContentPane().add(btnPanel);
		
		JButton btnLogin = new JButton("Login");
		btnPanel.add(btnLogin);
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
						SellerGUI.main(null,a[0]);
					
					break;
				case "3":
					
					break;
				default:
					break;
				}
			}
		});
	}
}
