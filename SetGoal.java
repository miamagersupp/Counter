import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Simple GUI designed to take a number value as a set goal to achieve. This
 * number could represent people, paper clips, phone numbers, etc.
 *
 * @author Mia Magersupp
 * @since 07/06/2019
 *
 */

public class SetGoal extends JFrame {

    String goal = "";

    public SetGoal() {

        JButton enter = new JButton("Enter");
        enter.addActionListener(new ManualSubmission());

        JFrame frame = new JFrame();
        frame.getRootPane().setDefaultButton(enter);
        frame.setSize(200, 80);

        TitledBorder title = new TitledBorder("Enter Today's Goal Below:");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitlePosition(TitledBorder.TOP);

        JTextArea txt = new JTextArea(" " + this.goal + "          ");
        txt.setEditable(false);
        txt.addKeyListener(new KeyListener() {
            //keys registered in text area
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE
                        || e.getKeyChar() == KeyEvent.VK_DELETE) {
                    SetGoal.this.goal = SetGoal.this.goal.substring(0,
                            SetGoal.this.goal.length() - 1);
                }
                if (Character.isDigit(e.getKeyChar())) {
                    SetGoal.this.goal = SetGoal.this.goal + e.getKeyChar();
                }
                txt.setText(" " + SetGoal.this.goal + "  ");
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        JPanel panel = new JPanel();
        panel.setBorder(title);
        panel.add(txt, BorderLayout.NORTH);
        panel.add(enter, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

    }

    //action when "Enter" key is pressed
    private class ManualSubmission implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            new KeepingCount(SetGoal.this.goal);

        }

    }

}
