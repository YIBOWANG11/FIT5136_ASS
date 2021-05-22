package code.GUI;

import code.GUI.entity.Chair;
import code.entity.Conference;
import code.transfer.TimeUtils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author lucks
 * @date 2021/5/15 18:45
 */
public class ModifyPage extends JFrame {

  private JPanel contentPane;
  ModifyPage frame;
  /**
   * Launch the application.
   */
  public void init19() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new ModifyPage();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public ModifyPage(){
    Chair chair = new Chair();

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 350);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

//    JPanel pnlContent = new JPanel();
//    pnlContent.setBounds(10, 11, 450, 600);
//    contentPane.add(pnlContent);
//    pnlContent.setLayout(null);

    JPanel pnlHeading = new JPanel();
    pnlHeading.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    pnlHeading.setBounds(20, 11, 380, 51);
    contentPane.add(pnlHeading);
    pnlHeading.setLayout(null);

    JLabel lblNewLabel = new JLabel("CMS");
    lblNewLabel.setBounds(80, 0, 161, 28);
    pnlHeading.add(lblNewLabel);
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));

    JLabel lblNewLabel_1 = new JLabel("**************** Modify Conference ***************");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setBounds(10, 26, 350, 25);
    pnlHeading.add(lblNewLabel_1);

    String[] columnName = getColumnName();
    String[][] columnData = getColumnData(chair);
    JTable conferenceTable = new JTable(columnData,columnName);
    JScrollPane jScrollPane = new JScrollPane(conferenceTable);
    jScrollPane.setBounds(20,80,400,100);
    contentPane.add(jScrollPane, BorderLayout.CENTER);

    JLabel idLabel = new JLabel("ID");
    idLabel.setFont(new Font("Arial",Font.PLAIN,12));
    idLabel.setBounds(20,190,40,25);

    JLabel titleLabel = new JLabel("Title");
    titleLabel.setFont(new Font("Arial",Font.PLAIN,12));
    titleLabel.setBounds(145,190,80,25);

    JLabel deadLineLabel = new JLabel("DeadLine");
    deadLineLabel.setFont(new Font("Arial",Font.PLAIN,12));
    deadLineLabel.setBounds(280,190,80,25);

    contentPane.add(idLabel);
    contentPane.add(titleLabel);
    contentPane.add(deadLineLabel);

    JTextField idText = new JTextField();
    idText.setColumns(10);
    idText.setBounds(20,220,100,25);
    JTextField titleText = new JTextField();
    titleText.setColumns(10);
    titleText.setBounds(145,220,100,25);
    JTextField deadLineText = new JTextField();
    deadLineText.setBounds(280,220,100,25);
    contentPane.add(idText);
    contentPane.add(titleText);
    contentPane.add(deadLineText);

    JButton btcModify = new JButton("Modify");
    btcModify.setFont(new Font("Arial",Font.BOLD,16));
    btcModify.setBounds(150,255,88,25);
    contentPane.add(btcModify);


    btcModify.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String id = idText.getText().trim();
        String title = titleText.getText().trim();
        String deadLine = deadLineText.getText().trim();

        if(id.isEmpty()) {
          JOptionPane.showMessageDialog(frame, " Please fill id , You Can't left id blank ");
        }
        else
        {
          if (!deadLine.isEmpty()&&!TimeUtils.checkFormat(deadLine))
            JOptionPane.showMessageDialog(frame, " deadLine format error.");
          else{
            Conference conference = new Conference();
            conference.setId(Integer.parseInt(id));
            conference.setTitle(title);
            conference.setDeadline(deadLine);
            chair.modifyConference(conference);
            setVisible(false);
            JOptionPane.showMessageDialog(frame, "Modify Conference Successful");
          }
        }
      }
    });
  }



  public String[] getColumnName(){
    return new String[]{"id","title","deadLine"};
  }

  public String[][] getColumnData(Chair chair){
    List<Conference> conferences = chair.listConference();
    String[][] result = new String[conferences.size()][3];
    for (int i = 0; i < conferences.size(); i++) {
      result[i][0] = String.valueOf(conferences.get(i).getId());
      result[i][1] = String.valueOf(conferences.get(i).getTitle());
      result[i][2] = String.valueOf(conferences.get(i).getDeadline());
    }

    return result;
  }
}
