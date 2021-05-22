package code.GUI;

import code.GUI.entity.Chair;

import code.entity.Conference;
import code.entity.Paper;
import java.util.List;
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

        String[][] columnData = getColumnData(chair);
        String[] fieldsData = new String[]{"id","state"};
        JTable conferenceTable = new JTable(columnData,fieldsData);
        JScrollPane jScrollPane = new JScrollPane(conferenceTable);
        jScrollPane.setBounds(20,80,200,100);
        pnlForm.add(jScrollPane,BorderLayout.CENTER);

    }


    public String[][] getColumnData(Chair chair){
        List<Paper> conferences = chair.listDonePaper();
        String[][] result = new String[conferences.size()][3];
        for (int i = 0; i < conferences.size(); i++) {
            result[i][0] = String.valueOf(conferences.get(i).getId());
            result[i][1] = String.valueOf(conferences.get(i).getState());
        }

        return result;
    }
}
