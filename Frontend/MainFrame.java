/*
 * First Frame for the Toll Gate Management System
 */

package Frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Frontend.Employee.Login;
import Frontend.Record.AllRecord;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class MainFrame implements ActionListener {
    JFrame frame;
    JLabel heading;
    JButton record, login;

    public MainFrame() {
        frame = new JFrame("TollGate Management System");

        ImageIcon background = new ImageIcon("E:\\toll gate management\\images\\bg-1.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 600, 500);

        heading = new JLabel("Toll Management System");
        heading.setBounds(50, 110, 500, 50);
        heading.setFont(new Font("Verdana", Font.PLAIN, 17));

        login = new JButton("Login");
        login.setBounds(50, 180, 100, 50);
        login.addActionListener(this);

        record = new JButton("All Records");
        record.setBounds(50, 260, 110, 50);
        record.addActionListener(this);

        frame.add(heading);
        frame.add(login);
        frame.add(record);
        frame.add(back);

        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Login")) {
            frame.setVisible(false);
            new Login();
        }
        if (s.equals("All Records")) {
            frame.setVisible(false);
            new AllRecord();
        }
    }
}
