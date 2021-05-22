package code.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		JLabel lblCMS = new JLabel("CMS");
		lblCMS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCMS.setFont(new Font("Arial", Font.BOLD, 20));
		lblCMS.setBounds(84, 11, 232, 31);
		frame.getContentPane().add(lblCMS);
		
		JLabel lblWelcome = new JLabel("************* Welcome to CMS *************");
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 42, 414, 31);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblOption = new JLabel("Please choose option below");
		lblOption.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOption.setBounds(20, 80, 374, 31);
		frame.getContentPane().add(lblOption);
		
		JButton btnLogin19 = new JButton("Login");
		btnLogin19.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin19.setBounds(30, 122, 167, 36);
		frame.getContentPane().add(btnLogin19);
		
		JButton btnRegister19 = new JButton("Register");
		btnRegister19.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegister19.setBounds(30, 169, 167, 36);
		frame.getContentPane().add(btnRegister19);
		
		btnLogin19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				new Login().init19();
			}
		});
		
		btnRegister19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				new Register().init19();
			}
		});
	}
}
