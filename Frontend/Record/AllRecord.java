package Frontend.Record;

import javax.swing.JFrame;

public class AllRecord {
    JFrame allRecordFrame;

    public AllRecord() {
        allRecordFrame = new JFrame("TollGate Management System_All Records");

        allRecordFrame.setSize(600, 500);
        allRecordFrame.setLayout(null);
        allRecordFrame.setVisible(true);
        allRecordFrame.setLocationRelativeTo(null);
        allRecordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
