import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

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
            for(Student jay : container)
                System.out.println(jay);
            dispose();
        });
        addButton.addActionListener(e -> {
            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }catch (RentalSystemException ex) {
                /*JOptionPane.showMessageDialog(null, "ERROR:\n" + ex.getMessage(), "Fehlermeldung", JOptionPane.WARNING_MESSAGE);*/                // einfacher, funktioniert auch

                JLabel errorWindow = new JLabel( ex.getMessage() );
                errorWindow.setForeground(Color.RED);
                errorWindow.setFont(new Font("Arial Black", Font.PLAIN, 30));

                JOptionPane.showMessageDialog(
                        null,
                        errorWindow,
                        "ERROR",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
        removeButton.addActionListener(e -> {

          if (!(container.removeStudent(email.getText()))){
              try {
                  throw new RentalSystemException.EMailNotFound();
              } catch (RentalSystemException.EMailNotFound ex) {
                  JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                  clear();
                  return;
              }
          }

            try(FileWriter wirter = new FileWriter("Student.csv")) {

                for (Iterator<Student> it = container.iterator(); it.hasNext(); ) {

                    Student g = it.next();
                    wirter.write(g.toString());
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }

            clear();
        });

        add(studentPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(addressPanel, BorderLayout.CENTER);
    }

    private void save() throws IOException, RentalSystemException {

        address = new Address(road.getText(), houseNumber.getText(), postalCode.getText(),
                city.getText());

        student = new Student(email.getText(), name.getText(), lastName.getText(), phoneNumber.getText(), address);

        if (studentExists(student.geteMail())) {
            throw new RentalSystemException.EmailAlreadyExists();
        }

        container.addStudent(student);

        try(FileWriter writer = new FileWriter("Student.csv", true)) {

            writer.write(student.toString());
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

    private boolean studentExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Student.csv"))) {
            String check;
            while ((check = reader.readLine()) != null) {
                String[] parts = check.split(",");
                if (parts.length > 0 && parts[0].equalsIgnoreCase(email.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
