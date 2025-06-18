import javax.swing.*;
import java.awt.*;

public class VerleihNix extends JFrame {

    public VerleihNix() {

        setTitle("VerleihNix");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Student hinzufügen");
        JButton button2 = new JButton("Objekt hinzufügen");
        JButton button3 = new JButton("Schließen");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        button3.addActionListener(e -> {
            dispose();
        });
        button1.addActionListener(e -> {
            addStudent student = new addStudent(this);
            student.setVisible(true);
        });

        add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);

    }

    public static void main(String[] args) {

        new VerleihNix();
    }
}
