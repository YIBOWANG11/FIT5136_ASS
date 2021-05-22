package code.GUI;

import code.GUI.entity.Chair;
import code.entity.Evaluation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ChairPage extends JFrame {

	private JPanel contentPane;
	ChairPage frame;
	/**
	 * Launch the application.
	 */
	public void init19() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChairPage();
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
	public ChairPage() {
		Chair chair = new Chair();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
				Home home19=new Home();
				home19.frame.setVisible(true);
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlHeading = new JPanel();
		pnlHeading.setBounds(10, 11, 399, 87);
		contentPane.add(pnlHeading);
		pnlHeading.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CMS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 11, 173, 23);
		pnlHeading.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("**********Welcome Chair, operation page **********");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 37, 379, 47);
		pnlHeading.add(lblNewLabel_1);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBounds(10, 50, 399, 200);
		contentPane.add(pnlBody);
		pnlBody.setLayout(null);

		JButton btnCreate = new JButton("Create Conference");
		btnCreate.setBounds(30, 60, 150, 32);
		pnlBody.add(btnCreate);
		
		JButton btnModify = new JButton("Modify Conference");
		btnModify.setBounds(190, 60, 150, 32);
		pnlBody.add(btnModify);

		JButton btnSendPaper = new JButton("Send paper");
		btnSendPaper.setBounds(30, 100, 150, 32);
		pnlBody.add(btnSendPaper);

		JButton btnViewEvaluation = new JButton("Give final result");
		btnViewEvaluation.setBounds(190, 100, 150, 32);
		pnlBody.add(btnViewEvaluation);

		JButton btnNotification = new JButton("Notification");
		btnNotification.setBounds(30, 140, 150, 32);
		pnlBody.add(btnNotification);

		//显示收到的paper review完成列表
		JButton btnView =null;
		List<Evaluation> notification = chair.notification();
		if (notification!=null&&notification.size()!=0){
			JLabel notificationLabel =  new JLabel("You got message.");
			notificationLabel.setFont(new Font("Arial",Font.BOLD,16));
			notificationLabel.setBounds(30,120,150,32);
			pnlBody.add(notificationLabel);

			btnView = new JButton("View Evaluation");
			btnView.setBounds(190,120,150,32);
			pnlBody.add(btnView);
		}


		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreatePage().init19();
			}
		});

		btnNotification.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Notification().init19();
			}
		});


		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ModifyPage().init19();
			}
		});

		if (btnView!=null){
			btnView.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new ViewPage().init19();
				}
			});
		}

		btnSendPaper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SendPaper().init19();
			}
		});

		btnViewEvaluation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeDecision().init19();
			}
		});


	}

}
