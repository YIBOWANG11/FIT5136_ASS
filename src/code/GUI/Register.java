package code.GUI;

import code.entity.User;
import code.repo.UserRepository;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtName19;
	private JTextField txtEmail;
	private JTextField txtMobile;
	private JTextField txtHighestQuali;
	private JTextField txtOccupation;
	private JTextField txtEmployerDetail;
	private JTextField txtInterestArea;

	Register frame;
	private JPasswordField txtPassword19;
	/**
	 * Launch the application.
	 */
	public void init19() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Register();
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
	public Register() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
				Home home19=new Home();
				home19.frame.setVisible(true);
			}
		});

		UserRepository userRepository = UserRepository.getInstance();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBounds(10, 11, 816, 418);
		contentPane.add(pnlContent);
		pnlContent.setLayout(null);
		
		JPanel pnlHeading = new JPanel();
		pnlHeading.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlHeading.setBounds(138, 11, 556, 51);
		pnlContent.add(pnlHeading);
		pnlHeading.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CMS");
		lblNewLabel.setBounds(175, 0, 161, 28);
		pnlHeading.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("************************* Welcome to CMS *************************");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 26, 523, 25);
		pnlHeading.add(lblNewLabel_1);
		
		JPanel pnlForm = new JPanel();
		pnlForm.setBounds(10, 73, 796, 334);
		pnlContent.add(pnlForm);
		pnlForm.setLayout(null);
		
		JLabel lblName = new JLabel("userId");
		lblName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblName.setBounds(10, 79, 166, 27);
		pnlForm.add(lblName);
		
		txtName19 = new JTextField();
		txtName19.setBounds(186, 79, 193, 27);
		pnlForm.add(txtName19);
		txtName19.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(417, 79, 166, 27);
		pnlForm.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(593, 79, 193, 27);
		pnlForm.add(txtEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(10, 132, 166, 27);
		pnlForm.add(lblPassword);

		JButton btnSubmit = new JButton("Register");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
		btnSubmit.setBounds(259, 288, 262, 35);
		pnlForm.add(btnSubmit);
		
		JLabel lblYouAreAn = new JLabel("You are ");
		lblYouAreAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouAreAn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblYouAreAn.setBounds(156, 11, 166, 27);
		pnlForm.add(lblYouAreAn);
		
		JComboBox cmbPosition = new JComboBox();
		cmbPosition.setModel(new DefaultComboBoxModel(new String[] {"Chair", "Reviewer", "Author"}));
		cmbPosition.setBounds(346, 11, 166, 27);
		pnlForm.add(cmbPosition);
		
		txtPassword19 = new JPasswordField();
		txtPassword19.setBounds(186, 132, 193, 27);
		pnlForm.add(txtPassword19);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					
					String name19=txtName19.getText().trim();
					String email19=txtEmail.getText().trim();
					String password19=txtPassword19.getText().trim();
					String role = cmbPosition.getSelectedItem()+ "";


					
					if(name19.isEmpty() || email19.isEmpty() || password19.isEmpty()) {
						
						
						JOptionPane.showMessageDialog(frame, " Please fill all fileds , You Can't left any field blank ");
						
					}
					else
					{
						if(isValidPassword19(password19)) {
							
							if(userRepository.findByUserEmail(name19)!=null) {
								
								JOptionPane.showMessageDialog(frame, " You Can't register with same position again!");
								JOptionPane.showMessageDialog(frame, " Registration Unsuccessful");
								
							}
							else {
								//Todo 注册角色全部是chair
								User chair = new User(Integer.parseInt(name19), email19, password19,role);
								userRepository.addOne(chair);
								JOptionPane.showMessageDialog(frame, " Registration Successful");
								setVisible(false);
								new Login().init19();
							}
							
						}
						else {
						
							JOptionPane.showMessageDialog(frame, " The password must be at least 8 characters long, "
									+ "must include at least 1 upper" + 
									"case, 1 lower case, 1 number.!");
							
						}
						
					}
					
					
					
				}
				catch (Exception e19) {
					JOptionPane.showMessageDialog(frame, " Registration Unsuccessful");
					e19.printStackTrace();
				}
			}
		});
		
		
	}
	
	
	
	
    public boolean isValidPassword19(String password19)
    {
  
       
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=\\S+$).{8,30}$";
  
        
        Pattern p = Pattern.compile(regex);
  
        if (password19 == null) {
            return false;
        }
  
   
        Matcher m = p.matcher(password19);
  
        return m.matches();
    }
	
}


