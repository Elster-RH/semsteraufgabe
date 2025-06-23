import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addStudent extends JDialog {

    private Student student;
    private Address address;
    private StudentContainer container;

    private JTextField name ;
    private JTextField lastName;
    private JTextField email;
    private JTextField phoneNumber;
    private JTextField road;
    private JTextField city;
    private JTextField houseNumber;
    private JTextField postalCode;


    public addStudent(JFrame parent, StudentContainer container) {
        super(parent, "Student hinzufügen", true);
        this.container = container;

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

        JLabel roadLabel = new JLabel("Strasse:");
        JLabel houseNumberLabel = new JLabel("Hausnummer:");
        JLabel postalCodeLabel = new JLabel("PLZ:");
        JLabel cityLabel = new JLabel("Stadt:");




        addressPanel.add(roadLabel);
        road = new JTextField(20);
        addressPanel.add(road);
        addressPanel.add(houseNumberLabel);
        houseNumber = new JTextField(20);
        addressPanel.add(houseNumber);
        addressPanel.add(postalCodeLabel);
        postalCode =  new JTextField(20);
        addressPanel.add(postalCode);
        addressPanel.add(cityLabel);
        city = new JTextField(20);
        addressPanel.add(city);


        studentPanel.add(studentName);
        name = new JTextField(20);
        studentPanel.add(name);
        studentPanel.add(studentName2);
        lastName = new JTextField(20);
        studentPanel.add(lastName);
        studentPanel.add(studentEmail);
        email = new JTextField(20);
        studentPanel.add(email);
        studentPanel.add(studentPhone);
        phoneNumber = new JTextField(20);
        studentPanel.add(phoneNumber);


        JButton addButton = new JButton("Student hinzufügen");
        JButton removeButton = new JButton("Student entfernen");
        JButton cancelButton = new JButton("Schließen");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            dispose();
        });
        addButton.addActionListener(e -> {
            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (RentalSystemException ex) {
                ex.getMessage();
            }
        });
        removeButton.addActionListener(e -> {
            for(Student jay : container)
            System.out.println(jay);
        });

        add(studentPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(addressPanel, BorderLayout.CENTER);
    }

    private void save() throws IOException, RentalSystemException {

        address = new Address(road.getText(), houseNumber.getText(), postalCode.getText(),
                city.getText());

        student = new Student(email.getText(), name.getText(), lastName.getText(), phoneNumber.getText(), address);

        container.addStudent(student);




        try(FileWriter wirter = new FileWriter("Student.csv", true)) {

            wirter.write(student.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }

        clear();

    }

    private void clear() {
        name.setText("");
        lastName.setText("");
        email.setText("");
        phoneNumber.setText("");
        road.setText("");
        city.setText("");
        houseNumber.setText("");
        postalCode.setText("");

    }

}
