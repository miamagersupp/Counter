import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Simple GUI designed to keep track of something incrementally (+1) then
 * compare it to a goal set in a previous GUI.
 *
 * @author Mia Magersupp
 * @since 07/06/2019
 *
 */

public class KeepingCount extends JFrame {

    JPanel top = new JPanel(new FlowLayout());
    JLabel lbl = new JLabel("Count: ");
    int count;
    int goal;
    JTextArea txt = new JTextArea(" " + this.count + "           ");

    JPanel bottom = new JPanel(new FlowLayout());
    JButton inc = new JButton("Increment");
    JButton dec = new JButton("Decrement");

    //constructor to set up GUI
    public KeepingCount(String s) {

        JFrame frame = new JFrame("Customer Counter");
        frame.setSize(250, 110);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        TitledBorder border = new TitledBorder("Get counting!");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);

        this.top.setBorder(border);
        this.top.setBackground(Color.yellow);

        this.setLayout(new BorderLayout());
        this.add(this.top, BorderLayout.CENTER);
        this.add(this.bottom, BorderLayout.SOUTH);
        this.top.add(this.lbl);
        this.txt.setEditable(false);
        this.top.add(this.txt);
        this.bottom.add(this.inc);
        this.inc.addActionListener(new ButtonListenerIncrease());

        this.bottom.add(this.dec);
        this.dec.addActionListener(new ButtonListenerDecrease());

        frame.add(this.top, BorderLayout.NORTH);
        frame.add(this.bottom, BorderLayout.SOUTH);
        frame.setVisible(true);

        this.goal = Integer.parseInt(s);

    }

    //action when number increased
    private class ButtonListenerIncrease implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            KeepingCount.this.count++;
            KeepingCount.this.txt
                    .setText(" " + KeepingCount.this.count + "           ");
            if (KeepingCount.this.count == KeepingCount.this.goal) {
                JDialog box = new JDialog();
                JLabel l = new JLabel("Congragulations!");
                JLabel la = new JLabel(" You met today's goal!");
                box.add(l, BorderLayout.NORTH);
                box.add(la, BorderLayout.SOUTH);
                box.setSize(200, 70);
                box.setVisible(true);
            }
        }
    }

    //action when number decreased
    private class ButtonListenerDecrease implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            KeepingCount.this.count--;
            KeepingCount.this.txt
                    .setText(" " + KeepingCount.this.count + "           ");
        }

    }

}
