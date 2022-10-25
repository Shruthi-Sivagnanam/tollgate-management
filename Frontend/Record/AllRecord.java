package Frontend.Record;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import Backend.Record.RecordDetails;
import Frontend.MainFrame;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AllRecord implements ActionListener {
    JFrame allRecordFrame;
    JButton bback;
    JLabel heading;
    RecordDetails ob;
    JTable jrecord;

    public AllRecord() {
        allRecordFrame = new JFrame("TollGate Management System_All Records");

        ob = new RecordDetails();
        ArrayList<String> s = ob.allRecords();

        ImageIcon background = new ImageIcon("E:\\toll gate management\\images\\bg-1.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 600, 500);

        bback = new JButton("<--");
        bback.setBounds(20, 10, 40, 30);
        bback.addActionListener(this);

        heading = new JLabel("All records");
        heading.setBounds(50, 60, 500, 50);
        heading.setFont(new Font("Verdana", Font.PLAIN, 17));

        jrecord = new JTable((s.size() / 4) + 1, 4);
        jrecord.setBounds(50, 150, 450, s.size() / 4 * 25);

        Color color = UIManager.getColor("Table.gridColor");
        MatteBorder border = new MatteBorder(1, 1, 1, 1, color);
        jrecord.setBorder(border);

        jrecord.setValueAt("Name", 0, 0);
        jrecord.setValueAt("Vechile", 0, 1);
        jrecord.setValueAt("Vechile Number", 0, 2);
        jrecord.setValueAt("Time", 0, 3);

        int a = s.size();
        int j = 0;
        for (int i = 1; i <= a / 4; i++) {
            jrecord.setValueAt(s.get(j), i, 0);
            j++;
            jrecord.setValueAt(s.get(j), i, 1);
            j++;
            jrecord.setValueAt(s.get(j), i, 2);
            j++;
            jrecord.setValueAt(s.get(j), i, 3);
            j++;
            if (j == a)
                break;
        }

        allRecordFrame.add(bback);
        allRecordFrame.add(heading);
        allRecordFrame.add(jrecord);
        allRecordFrame.add(back);

        allRecordFrame.setSize(600, 500);
        allRecordFrame.setLayout(null);
        allRecordFrame.setVisible(true);
        allRecordFrame.setLocationRelativeTo(null);
        allRecordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("<--")) {
            allRecordFrame.setVisible(false);
            new MainFrame();
        }

    }
}
