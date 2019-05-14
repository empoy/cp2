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
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

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
		frmLogin = new JFrame("MigLayout");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 531, 384);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box verticalBox = Box.createVerticalBox();
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 22));
		username.setColumns(15);
		//frmLogin.getContentPane().add(usernamePanel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		password.setColumns(15);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
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
						CustomerGUI.main(null);
					break;
				default:
					break;
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(username)
								.addComponent(password))))
					.addGap(79))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
}
