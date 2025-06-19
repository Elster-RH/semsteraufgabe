import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerleihNix extends JFrame {



    public VerleihNix(StudentContainer container) {

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
            addStudent student = new addStudent(this, container);
            student.setVisible(true);
        });

        add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);

    }



    public static void main(String[] args) throws FileNotFoundException {

        StudentContainer container = new StudentContainer();


        try(Scanner input = new Scanner(new File("Student.csv"))){
            while (input.hasNextLine()) {
                Address address = new Address(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
                Student student = new Student(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), address);
                container.addStudent(student);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        new VerleihNix(container);
    }
}
