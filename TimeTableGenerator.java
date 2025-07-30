import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TimeTableGenerator extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JComboBox cbDays, cbPeriod, cbSubject, cbTeacher;

    public TimeTableGenerator() {
        setTitle("Time Table Generator");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Days and Periods
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] periods = {"1", "2", "3", "4", "5", "6", "7"};
        String[] subjects = {"Math", "Science", "History", "English", "Computer"};
        String[] teachers = {"Mr. Matthew", "Ms. Betty", "Mr. Charles", "Mrs. Jones"};

        // Combo Panel
        JPanel comboPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        comboPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        comboPanel.setBackground(new Color(195, 177, 225));

        cbDays = new JComboBox<>(days);
        cbDays.setBackground(Color.DARK_GRAY);   
        cbDays.setForeground(Color.WHITE); 
        cbPeriod = new JComboBox<>(periods);
        cbPeriod.setBackground(Color.DARK_GRAY);   
        cbPeriod.setForeground(Color.WHITE); 
        cbSubject = new JComboBox<>(subjects);
        cbSubject.setBackground(Color.DARK_GRAY);   
        cbSubject.setForeground(Color.WHITE); 
        cbTeacher = new JComboBox<>(teachers);
        cbTeacher.setBackground(Color.DARK_GRAY);   
        cbTeacher.setForeground(Color.WHITE); 
        JButton btnAssign = new JButton("Assign");
        btnAssign.setBackground(Color.PINK);

        comboPanel.add(new JLabel("Select Day:"));
        comboPanel.add(cbDays);
        comboPanel.add(new JLabel("Select Period:"));
        comboPanel.add(cbPeriod);
        comboPanel.add(new JLabel("Select Subject:"));
        comboPanel.add(cbSubject);
        comboPanel.add(new JLabel("Select Teacher:"));
        comboPanel.add(cbTeacher);
        add(comboPanel, BorderLayout.SOUTH);

        // Table
        String[] columnNames = {"Day", "Period 1", "Period 2", "Period 3", "Period 4", "Period 5", "Period 6", "Period 7"};
        String[][] data = {
            {"Monday", "", "", "", "", "", "", ""},
            {"Tuesday", "", "", "", "", "", "", ""},
            {"Wednesday", "", "", "", "", "", "", ""},
            {"Thursday", "", "", "", "", "", "", ""},
            {"Friday", "", "", "", "", "", "", ""}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setRowHeight(30);
        table.setBackground(new Color(208, 240, 192)); 
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button
        btnAssign.addActionListener(e -> assignSubject());
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAssign);
        add(btnPanel, BorderLayout.NORTH);
    }

    private void assignSubject() {
        int dayIndex = cbDays.getSelectedIndex();
        int periodIndex = cbPeriod.getSelectedIndex() + 1;

        String subject = cbSubject.getSelectedItem().toString();
        String teacher = cbTeacher.getSelectedItem().toString();

        String value = subject + "\n(" + teacher + ")";
        model.setValueAt(subject + " (" + teacher + ")", dayIndex, periodIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimeTableGenerator().setVisible(true));
    }
}