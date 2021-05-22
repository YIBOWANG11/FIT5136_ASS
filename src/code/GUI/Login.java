package code.GUI;

import code.entity.User;
import code.repo.UserRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;
	
	Login frame;
	private JPasswordField txtPassword19;

	/**
	 * Launch the application.
	 */
	public void init19() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		UserRepository userRepository = UserRepository.getInstance();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
				Home home19=new Home();
				home19.frame.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 18));
		lblLogin.setBounds(111, 35, 201, 28);
		contentPane.add(lblLogin);
		
		JLabel lblUserId19 = new JLabel("User ID");
		lblUserId19.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUserId19.setBounds(38, 85, 110, 28);
		contentPane.add(lblUserId19);
		
		txtUserId = new JTextField();
		txtUserId.setBounds(168, 82, 194, 35);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(38, 131, 110, 28);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBounds(111, 191, 164, 35);
		contentPane.add(btnLogin);
		
		txtPassword19 = new JPasswordField();
		txtPassword19.setBounds(168, 128, 194, 31);
		contentPane.add(txtPassword19);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					String id19=txtUserId.getText().trim();
					String password19=txtPassword19.getText().trim();

					if(id19.isEmpty() || password19.isEmpty()) {
						
						JOptionPane.showMessageDialog(frame, " Login Id and Password can't be blank");
					}
					else {
						User user = userRepository.findByUserEmail(id19);
						if(user!=null&&user.getPassword().equals(password19)) {
							
							JOptionPane.showMessageDialog(frame, " Login Successful ");
							setVisible(false);
							
							new ChairPage().init19();
							
						}
						else {
							
							JOptionPane.showMessageDialog(frame, " Invalid Login Id and Password , try again!");

						}
					}
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(frame, " Login Unsuccessful ");
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
