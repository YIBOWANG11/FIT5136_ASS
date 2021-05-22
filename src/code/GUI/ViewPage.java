package code.GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author lucks
 * @date 2021/5/15 18:46
 */
public class ViewPage extends JFrame {

  private JPanel contentPane;
  ViewPage frame;
  /**
   * Launch the application.
   */
  public void init19() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new ViewPage();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }


  public ViewPage(){

  }
}
