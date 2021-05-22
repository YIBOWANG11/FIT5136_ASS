package code.GUI;

import code.GUI.entity.Chair;
import code.entity.Paper;
import code.entity.Reviewer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SendPaper extends JFrame {
    private JPanel contentPane;
    private SendPaper frame;
    public void init19() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new SendPaper();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SendPaper(){

        Chair chair = new Chair();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300); //界面大小
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
//
//        JLabel lblNewLabel = new JLabel("CMS");
//        lblNewLabel.setBounds(80, 0, 161, 28);
//        pnlHeading.add(lblNewLabel);
//        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel lblNewLabel_1 = new JLabel("**************** Send paper ***************");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 26, 350, 25);
        pnlHeading.add(lblNewLabel_1);

        JPanel pnlForm = new JPanel();
        pnlForm.setBounds(20,80,100,100);
        pnlContent.add(pnlForm);
        pnlForm.setLayout(null);

        String[] columnName = getPaperName();
        String[][] columnData = getPaperData(chair);
        JTable paperTable = new JTable(columnData,columnName);
        JScrollPane jScrollPane = new JScrollPane(paperTable);
        jScrollPane.setBounds(20,80,100,100);
        contentPane.add(jScrollPane, BorderLayout.CENTER);

        String[] columnReviewer = getReviewerName();
        String[][] columnReviewerData = getReviewerData(chair);
        JTable reviewerTable = new JTable(columnReviewerData,columnReviewer);
        JScrollPane jScrollPane2 = new JScrollPane(reviewerTable);
        jScrollPane2.setBounds(60,160,400,100);
        contentPane.add(jScrollPane2, BorderLayout.CENTER);

        JLabel lblName = new JLabel("paper ID :");
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        lblName.setBounds(10, 30, 90, 27);
        pnlForm.add(lblName);

        JTextField paperID = new JTextField();
        paperID.setBounds(150, 30, 150, 27);
        paperID.setColumns(10);
        pnlForm.add(paperID);

        JLabel reviewers = new JLabel("reviewers ID :");
        reviewers.setFont(new Font("Arial", Font.BOLD, 15));
        reviewers.setBounds(10, 67, 100, 27);
        pnlForm.add(reviewers);

        JTextField idList = new JTextField();
        idList.setColumns(10);
        idList.setBounds(150, 67, 150, 27);
        pnlForm.add(idList);

        JButton btnSubmit = new JButton("Send");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
        btnSubmit.setBounds(150, 110, 88, 35);
        pnlForm.add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                    String paperStr=paperID.getText().trim();
                    String idStr=idList.getText().trim();

                    if(paperStr.isEmpty()||idStr.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, " Please fill all fields , You Can't left any field blank ");
                    }
                    else
                    {
                        String[] id_list = idStr.split(",");
                        List<Integer> id = Arrays.asList(id_list).stream().map(op->Integer.parseInt(op)).collect(Collectors.toList());
                        chair.assignPaper(Integer.parseInt(paperStr),id);
                        JOptionPane.showMessageDialog(frame, " Send paper successful");
                        setVisible(false);
                    }
                }
                catch (Exception e19) {
                    JOptionPane.showMessageDialog(frame, " Send Unsuccessful");
                    e19.printStackTrace();
                }
            }
        });
    }
    public String[] getPaperName(){
        return new String[]{"id","authorId","conferenceId","topic","name","submitTime","format","state"};
    }
    public String[] getReviewerName(){
        return new String[]{"reviewerId","authorId","conferenceId","topic","name","submitTime","format","state"};
    }

    public String[][] getPaperData(Chair chair){
        List<Paper> papers = chair.listPaper();
        String[][] result = new String[papers.size()][8];
        for (int i = 0; i < papers.size(); i++) {
            result[i][0] = String.valueOf(papers.get(i).getId());
            result[i][1] = String.valueOf(papers.get(i).getAuthorId());
            result[i][2] = String.valueOf(papers.get(i).getConferenceId());
            result[i][3] = String.valueOf(papers.get(i).getTopic());
            result[i][4] = String.valueOf(papers.get(i).getName());
            result[i][5] = String.valueOf(papers.get(i).getSubmitTime());
            result[i][6] = String.valueOf(papers.get(i).getFormat());
            result[i][7] = String.valueOf(papers.get(i).getState());
        }
        return result;
    }

    public String[][] getReviewerData(Chair chair){
        List<Reviewer> reviewers = chair.listReviewer();
        String[][] result2 = new String[reviewers.size()][8];
        for (int i = 0; i < reviewers.size(); i++) {
            result2[i][0] = String.valueOf(reviewers.get(i).getId());
            result2[i][1] = String.valueOf(reviewers.get(i).getAuthorId());
            result2[i][2] = String.valueOf(reviewers.get(i).getConferenceId());
            result2[i][3] = String.valueOf(reviewers.get(i).getTopic());
            result2[i][4] = String.valueOf(reviewers.get(i).getName());
            result2[i][5] = String.valueOf(reviewers.get(i).getSubmitTime());
            result2[i][6] = String.valueOf(reviewers.get(i).getFormat());
            result2[i][7] = String.valueOf(reviewers.get(i).getState());
        }
        return result2;
    }
}
