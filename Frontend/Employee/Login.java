/*
 * Login Frame 
 */

package Frontend.Employee;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Backend.Employee.LoginDetail;
import Frontend.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class Login implements ActionListener {
    JFrame loginFrame;
    JLabel heading, lusername, lpassword, lerror;
    JTextField tusername, tpassowrd;
    JButton blogin, bback;

    public Login() {
        loginFrame = new JFrame("TollGate Management System-Login");

        ImageIcon background = new ImageIcon("E:\\toll gate management\\images\\bg-1.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 600, 500);

        heading = new JLabel("Login");
        heading.setBounds(50, 60, 500, 50);
        heading.setFont(new Font("Verdana", Font.PLAIN, 17));

        lusername = new JLabel("Username: ");
        lusername.setBounds(50, 130, 100, 30);

        tusername = new JTextField();
        tusername.setBounds(150, 135, 100, 20);

        lpassword = new JLabel("Password: ");
        lpassword.setBounds(50, 170, 100, 30);

        tpassowrd = new JTextField();
        tpassowrd.setBounds(150, 175, 100, 20);

        blogin = new JButton("Login");
        blogin.setBounds(50, 250, 100, 30);
        blogin.addActionListener(this);

        lerror = new JLabel("");
        lerror.setBounds(50, 300, 100, 50);
        lerror.setVisible(false);

        bback = new JButton("<--");
        bback.setBounds(20, 10, 40, 30);
        bback.addActionListener(this);

        loginFrame.add(heading);
        loginFrame.add(lusername);
        loginFrame.add(tusername);
        loginFrame.add(lpassword);
        loginFrame.add(tpassowrd);
        loginFrame.add(blogin);
        loginFrame.add(bback);
        loginFrame.add(lerror);
        loginFrame.add(back);

        loginFrame.setSize(600, 500);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Login")) {
            String username = tusername.getText();
            String password = tpassowrd.getText();
            LoginDetail ob = new LoginDetail();
            int find = ob.loginDetail(username, password);
            if (find == 1) {
                loginFrame.setVisible(false);
                new TollForm();
            } else {
                System.out.println("No data");
                lerror.setText("No such data");
                lerror.setForeground(Color.RED);
                lerror.setVisible(true);
            }
        }
        if (s.equals("Back")) {
            loginFrame.setVisible(false);
            new MainFrame();
        }

    }
}
