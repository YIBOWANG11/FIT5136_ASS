package code.GUI;

import code.GUI.entity.Chair;
import code.entity.Conference;
import code.transfer.TimeUtils;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 * @author lucks
 * @date 2021/5/15 18:21
 */
public class CreatePage extends JFrame {

  private JPanel contentPane;
  private CreatePage frame;
  /**
   * Launch the application.
   */
  public void init19() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new CreatePage();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public CreatePage(){

    Chair chair = new Chair();

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel pnlContent = new JPanel();
    pnlContent.setBounds(10, 11, 450, 300);
    contentPane.add(pnlContent);
    pnlContent.setLayout(null);

    JPanel pnlHeading = new JPanel();
    pnlHeading.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    pnlHeading.setBounds(20, 11, 400, 51);
    pnlContent.add(pnlHeading);
    pnlHeading.setLayout(null);

    JLabel lblNewLabel = new JLabel("CMS");
    lblNewLabel.setBounds(80, 0, 161, 28);
    pnlHeading.add(lblNewLabel);
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));

    JLabel lblNewLabel_1 = new JLabel("**************** Create Conference ***************");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setBounds(10, 26, 350, 25);
    pnlHeading.add(lblNewLabel_1);

    JPanel pnlForm = new JPanel();
    pnlForm.setBounds(10, 73, 300, 300);
    pnlContent.add(pnlForm);
    pnlForm.setLayout(null);

    JLabel lblName = new JLabel("title :");
    lblName.setFont(new Font("Arial", Font.BOLD, 20));
    lblName.setBounds(10, 30, 60, 27);
    pnlForm.add(lblName);

    JTextField title = new JTextField();
    title.setBounds(150, 30, 150, 27);
    pnlForm.add(title);
    title.setColumns(10);

    JLabel lblEmail = new JLabel("deadLine :");
    lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
    lblEmail.setBounds(10, 67, 100, 27);
    pnlForm.add(lblEmail);

    JTextField deadLine = new JTextField();
    deadLine.setColumns(10);
    deadLine.setBounds(150, 67, 150, 27);
    pnlForm.add(deadLine);

    JButton btnSubmit = new JButton("Create");
    btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
    btnSubmit.setBounds(150, 110, 88, 35);
    pnlForm.add(btnSubmit);

    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {

          String titleStr=title.getText().trim();
          String deadLineStr=deadLine.getText().trim();

          if(titleStr.isEmpty()||deadLineStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, " Please fill all fields , You Can't left any field blank ");
          }
          else
          {
            if (!TimeUtils.checkFormat(deadLineStr))
              JOptionPane.showMessageDialog(frame, " deadLine format error.");
            else{
              Conference conference = new Conference();
              conference.setTitle(titleStr);
              conference.setDeadline(deadLineStr);
              chair.creatConference(conference);
              setVisible(false);
              JOptionPane.showMessageDialog(frame, "Create Conference Successful");
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

}
