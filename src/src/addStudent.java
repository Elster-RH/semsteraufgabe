import javax.swing.*;
import java.awt.*;

public class addStudent extends JDialog {
    public addStudent(JFrame parent) {
        super(parent, "Student hinzufügen", true);

        setSize(500, 250);

        JPanel buttonPanel = new JPanel();
        JPanel studentPanel = new JPanel();
        JPanel addressPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(4,2));
        addressPanel.setLayout(new GridLayout(4,2));
        addressPanel.setBorder(BorderFactory.createTitledBorder("Adresse"));


        JLabel studentName = new JLabel("Name:");
        JLabel studentName2 = new JLabel("Nachname:");
        JLabel studentEmail = new JLabel("Email:");
        JLabel studentPhone = new JLabel("Telefonnummer:");

        JLabel address1 = new JLabel("Strasse:");
        JLabel address2 = new JLabel("Hausnummer:");
        JLabel address3 = new JLabel("PLZ:");
        JLabel address4 = new JLabel("Stadt:");




        addressPanel.add(address1);
        addressPanel.add(new JTextField(20));
        addressPanel.add(address2);
        addressPanel.add(new JTextField(20));
        addressPanel.add(address3);
        addressPanel.add(new JTextField(20));
        addressPanel.add(address4);
        addressPanel.add(new JTextField(20));


        studentPanel.add(studentName);
        studentPanel.add(new JTextField(20));
        studentPanel.add(studentName2);
        studentPanel.add(new JTextField(20));
        studentPanel.add(studentEmail);
        studentPanel.add(new JTextField(30));
        studentPanel.add(studentPhone);
        studentPanel.add(new JTextField(20));


        JButton addButton = new JButton("Student hinzufügen");
        JButton removeButton = new JButton("Student entfernen");
        JButton cancelButton = new JButton("Schließen");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            dispose();
        });

        add(studentPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(addressPanel, BorderLayout.CENTER);
    }

}
