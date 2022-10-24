package Frontend.Employee;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Backend.TripFare;
import Backend.Record.RecordDetails;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class TollForm implements ActionListener {
    JFrame formFrame;
    JLabel heading, lvechileNumber, lname, lpayment;
    JTextField tvechileNumber, tname;
    JRadioButton rgbus, rbus, rcar, rtruck, rroundTrip, rsingleTrip, rcard, rcash;
    JButton bsubmit, bpaid;

    String name = "", type = "", number = "", trip = "", payment = "";
    float fare;

    public TollForm() {
        formFrame = new JFrame("TollGate Management System-Form");

        ImageIcon background = new ImageIcon("E:\\toll gate management\\images\\bg-1.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 600, 500);

        heading = new JLabel("Toll Both Form");
        heading.setBounds(50, 50, 500, 50);
        heading.setFont(new Font("Verdana", Font.PLAIN, 17));

        lname = new JLabel("Name of the customer: ");
        lname.setBounds(50, 100, 150, 30);

        tname = new JTextField();
        tname.setBounds(200, 105, 100, 20);

        rbus = new JRadioButton("Bus");
        rbus.setBounds(50, 130, 50, 30);
        rbus.addActionListener(this);
        rbus.setBackground(Color.WHITE);

        rcar = new JRadioButton("Car");
        rcar.setBounds(100, 130, 50, 30);
        rcar.addActionListener(this);
        rcar.setBackground(Color.WHITE);

        rtruck = new JRadioButton("Truck");
        rtruck.setBounds(150, 130, 70, 30);
        rtruck.addActionListener(this);
        rtruck.setBackground(Color.WHITE);

        rgbus = new JRadioButton("G-Bus");
        rgbus.setBounds(220, 130, 100, 30);
        rgbus.setBackground(Color.WHITE);
        rgbus.addActionListener(this);

        lvechileNumber = new JLabel("Vechile Number: ");
        lvechileNumber.setBounds(50, 160, 110, 30);

        tvechileNumber = new JTextField();
        tvechileNumber.setBounds(160, 165, 100, 20);

        rroundTrip = new JRadioButton("Round Trip");
        rroundTrip.setBounds(50, 190, 100, 30);
        rroundTrip.setBackground(Color.WHITE);
        rroundTrip.addActionListener(this);

        rsingleTrip = new JRadioButton("Single Trip");
        rsingleTrip.setBounds(150, 190, 100, 30);
        rsingleTrip.setBackground(Color.WHITE);
        rsingleTrip.addActionListener(this);

        bsubmit = new JButton("Submit");
        bsubmit.setBounds(50, 230, 100, 30);
        bsubmit.addActionListener(this);

        lpayment = new JLabel("");
        lpayment.setBounds(50, 250, 200, 30);
        lpayment.setVisible(false);

        rcard = new JRadioButton("Card Payment");
        rcard.setBounds(50, 280, 150, 30);
        rcard.setVisible(false);
        rcard.setBackground(Color.WHITE);

        rcash = new JRadioButton("Cash Payment");
        rcash.setBounds(200, 280, 150, 30);
        rcash.setVisible(false);
        rcash.setBackground(Color.WHITE);

        bpaid = new JButton("Paid");
        bpaid.setBounds(50, 330, 100, 30);
        bpaid.setVisible(false);
        bpaid.addActionListener(this);

        formFrame.add(heading);
        formFrame.add(lname);
        formFrame.add(tname);
        formFrame.add(rbus);
        formFrame.add(rcar);
        formFrame.add(rtruck);
        formFrame.add(rgbus);
        formFrame.add(lvechileNumber);
        formFrame.add(tvechileNumber);
        formFrame.add(rsingleTrip);
        formFrame.add(rroundTrip);
        formFrame.add(bsubmit);
        formFrame.add(lpayment);
        formFrame.add(rcard);
        formFrame.add(rcash);
        formFrame.add(bpaid);
        formFrame.add(back);

        formFrame.setSize(600, 500);
        formFrame.setLayout(null);
        formFrame.setVisible(true);
        formFrame.setLocationRelativeTo(null);
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {
            name = tname.getText();
            number = tvechileNumber.getText();
            if (rbus.isSelected())
                type = "Bus";
            if (rcar.isSelected())
                type = "Car";
            if (rtruck.isSelected())
                type = "Truck";
            if (rgbus.isSelected())
                type = "G-Bus";
            if (rroundTrip.isSelected())
                trip = "Round";
            if (rsingleTrip.isSelected())
                trip = "Single";
            System.out.println(name + " " + number + " " + type + " " + trip);
            TripFare ob = new TripFare();
            fare = ob.getFare(type, trip);
            System.out.print(fare);
            lpayment.setText(name + " has to pay " + fare);
            lpayment.setForeground(Color.GREEN);
            lpayment.setVisible(true);
            rcard.setVisible(true);
            rcash.setVisible(true);
            bpaid.setVisible(true);
        }
        if (s.equals("Paid")) {
            if (rcard.isSelected())
                payment = "Card";
            if (rcash.isSelected())
                payment = "Cash";
            RecordDetails ob1 = new RecordDetails();
            System.out.println(trip);
            ob1.insertRecord(name, type, number, trip, fare, payment);
        }
    }
}
