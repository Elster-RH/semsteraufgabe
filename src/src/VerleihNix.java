import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VerleihNix extends JFrame {

    public VerleihNix(StudentContainer container, GegenstaendeContainer objContainer) {

        setTitle("VerleihNix");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        JButton studentbutton = new JButton("Neuen Studenten anlegen");
        JButton bookbutton = new JButton("Objekt hinzufügen");
        JButton keyButton = new JButton("Neuen Schlüssel anlegen");
        JButton closebutton = new JButton("Schließen");
        JButton lentkeybutton = new JButton("Schluessel verleihen");
        JButton button5 = new JButton("Buch verleihen");
        buttonPanel.add(studentbutton);
        buttonPanel.add(keyButton);
        buttonPanel.add(bookbutton);
        buttonPanel.add(closebutton);
        centerPanel.add(lentkeybutton);
        centerPanel.add(button5);


        closebutton.addActionListener(e -> {
            dispose();
        });
        studentbutton.addActionListener(e -> {
            addStudent student = new addStudent(this, container);
            student.setVisible(true);
        });
        bookbutton.addActionListener(e -> {
            addObjekt objekt = new addObjekt(this, objContainer);
            objekt.setVisible(true);
        });
        keyButton.addActionListener(e -> {
            addSchluessel key = new addSchluessel(this, objContainer);
            key.setVisible(true);
        });

        lentkeybutton.addActionListener(e -> {
            lentSchluessel lentkey = new lentSchluessel(this, objContainer, container);
            lentkey.setVisible(true);
        });


        add(buttonPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);


        setVisible(true);

    }

    public static void main(String[] args) {

        StudentContainer container = new StudentContainer();
        GegenstaendeContainer objContainer = new GegenstaendeContainer();


        try (BufferedReader in1 = new BufferedReader(new FileReader("Student.csv"))) {
            String zeile;

            while ((zeile = in1.readLine()) != null) {

                String[] data = zeile.split(";");

                Address address;
                Student student;

                if (data.length == 8) {
                    String road = data[0];
                    String houseNumber = data[1];
                    String postCode = data[2];
                    String city = data[3];

                    try {
                        address = new Address(road, houseNumber, postCode, city);

                    } catch (RentalSystemException ex) {
                        throw new RuntimeException(ex);
                    }

                    String eMail = data[4];
                    String firstName = data[5];
                    String lastName = data[6];
                    String phoneNumber = data[7];

                    try {
                        student = new Student(eMail, firstName, lastName, phoneNumber, address);
                    } catch (RentalSystemException e) {
                        throw new RuntimeException(e);
                    }
                    container.addStudent(student);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in2 = new BufferedReader(new FileReader("Buch.csv"))) {
            String zeile;


            while ((zeile = in2.readLine()) != null) {

                String[] data = zeile.split(";");

                Schluessel key;

                if (data[0].contains("schluessel")) {

                    if (data[4].contains("null")) {
                        String comm = data[2];
                        String schliesst = data[3];
                        String pfand = data[5];
                        String lentdate = data[6];
                        String lentduration = data[7];


                        try {
                            key = new Schluessel(comm, schliesst, pfand, lentdate, lentduration);
                        } catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                        objContainer.addGegenstand(key);
                    } else {


                        String comm = data[2];
                        String schliesst = data[3];
                        String pfand = data[5];
                        String lentdate = data[6];
                        String lentduration = data[7];
                        String eMail = data[4];

                        Student student = container.getStudent(eMail);

                        try {
                            key = new Schluessel(comm, schliesst, student, pfand, lentdate, lentduration);
                        } catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                        objContainer.addGegenstand(key);
                    }


                }



            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new VerleihNix(container, objContainer);

    }
}
