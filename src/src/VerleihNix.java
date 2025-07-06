import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerleihNix extends JFrame {

    public VerleihNix(StudentContainer container, GegenstaendeContainer objContainer) {

        setTitle("VerleihNix");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setSize(300,150);

        JButton button1 = new JButton("Student hinzufügen");
        JButton button2 = new JButton("Objekt hinzufügen");
        JButton button3 = new JButton("Schließen");
        JButton button4 = new JButton("Schluessel verleihen");
        JButton button5 = new JButton("Buch verleihen");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        centerPanel.add(button4);
        centerPanel.add(button5);

        button3.addActionListener(e -> {
            dispose();
        });
        button1.addActionListener(e -> {
            addStudent student = new addStudent(this, container);
            student.setVisible(true);
        });
        button2.addActionListener(e -> {
            addObjekt objekt = new addObjekt(this, objContainer);
            objekt.setVisible(true);
        });


        add(buttonPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);


        setVisible(true);

    }

    public static void main(String[] args) {

        StudentContainer container = new StudentContainer();
        GegenstaendeContainer objContainer = new GegenstaendeContainer();


        try(Scanner input = new Scanner(new File("Student.csv"))){
            while (input.hasNextLine()) {
                Address address = new Address(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
                Student student = new Student(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), address);
                container.addStudent(student);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (RentalSystemException e) {
            e.printStackTrace();
        }


        new VerleihNix(container, objContainer);
    }
}
