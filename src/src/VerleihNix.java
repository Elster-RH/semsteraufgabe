import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class VerleihNix extends JFrame {

    public VerleihNix(StudentContainer container, GegenstaendeContainer objContainer) {

        setTitle("VerleihNix");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        JButton button1 = new JButton("Neuen Studenten anlegen");
        JButton button2 = new JButton("Objekt hinzufügen");
        JButton keyButton = new JButton("Neuen Schlüssel anlegen");
        JButton button3 = new JButton("Schließen");
        JButton button4 = new JButton("Schluessel verleihen");
        JButton button5 = new JButton("Buch verleihen");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(keyButton);
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
        keyButton.addActionListener(e -> {
            addSchluessel key = new addSchluessel(this, objContainer);
            key.setVisible(true);
        });


        add(buttonPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);


        setVisible(true);

    }

    public static void main(String[] args) {

        StudentContainer container = new StudentContainer();
        GegenstaendeContainer objContainer = new GegenstaendeContainer();


        try(BufferedReader in1 = new BufferedReader(new FileReader("Student.csv"))){
            String zeile;

            while ((zeile = in1.readLine()) != null) {

                String[] data = zeile.split(";");

                Address address;
                Student student;

                if(data.length == 8){
                    String road = data[0];
                    String houseNumber = data[1];
                    String postCode = data[2];
                    String city = data[3];

                    try{
                        address = new Address(road, houseNumber, postCode, city);

                    } catch (RentalSystemException ex) {
                        throw new RuntimeException(ex);
                    }

                    String eMail = data[4];
                    String firstName =  data[5];
                    String lastName = data[6];
                    String phoneNumber =  data[7];

                    try {
                        student = new Student (eMail, firstName, lastName, phoneNumber, address);
                    } catch (RentalSystemException e) {
                        throw new RuntimeException(e);
                    }
                    container.addStudent(student);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        new VerleihNix(container, objContainer);
    }
}
