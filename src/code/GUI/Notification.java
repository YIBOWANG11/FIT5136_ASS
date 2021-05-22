package code.GUI;

import code.GUI.entity.Chair;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notification extends JFrame {
    private JPanel contentPane;
    private Notification frame;
    public void init19() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Notification();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Notification(){

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

        JLabel lblNewLabel_1 = new JLabel("**************** Notification ***************");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 26, 350, 25);
        pnlHeading.add(lblNewLabel_1);

        JPanel pnlForm = new JPanel();
        pnlForm.setBounds(10, 73, 300, 300);
        pnlContent.add(pnlForm);
        pnlForm.setLayout(null);

        JLabel lblName = new JLabel("paper ID :");
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        lblName.setBounds(10, 30, 90, 27);
        pnlForm.add(lblName);

        JTextField paperID = new JTextField();
        paperID.setBounds(150, 30, 150, 27);
        pnlForm.add(paperID);
        paperID.setColumns(10);
        
        JButton btnSubmit = new JButton("State");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
        btnSubmit.setBounds(150, 110, 88, 35);
        pnlForm.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                        String paperStr=paperID.getText().trim();
//                      String stateStr=idList.getText().trim();
//
                    if(paperStr.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, " Please fill all fields , You Can't left any field blank ");
                    }
                    else
                    {
//                          String[] id_list = idStr.split(",");
//                          List<Integer> id = Arrays.asList(id_list).stream().map(op->Integer.parseInt(op)).collect(Collectors.toList());
////                        chair.assignPaper(Integer.parseInt(paperStr),id);
////                        JOptionPane.showMessageDialog(frame, " Send paper successful");
////                        setVisible(false);
                    }
                }
                catch (Exception e19) {
                    JOptionPane.showMessageDialog(frame, "Notification successfully");
                    e19.printStackTrace();
                }
            }
        });
    }
}
