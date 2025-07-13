import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class addStudent extends JDialog {

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
        super(parent, "Student hinzufügen", true);  // erstelle Fenster um ein studenten-objekt hinzuzufügen
        this.container = container;

        setSize(500, 250);


        JPanel buttonPanel = new JPanel();
        JPanel studentPanel = new JPanel();
        JPanel addressPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(5,2));
        addressPanel.setLayout(new GridLayout(4,2));
        addressPanel.setBorder(BorderFactory.createTitledBorder("Adresse"));


        JLabel studentName = new JLabel("Vorname:");                               //fetlegen der Labels(text auf dem Fenster
        JLabel studentName2 = new JLabel("Nachname:");
        JLabel studentEmail = new JLabel("Email:");
        JLabel studentPhone = new JLabel("Telefonnummer:");

        JLabel roadLabel = new JLabel("Strasse:");
        JLabel houseNumberLabel = new JLabel("Hausnummer:");
        JLabel postalCodeLabel = new JLabel("PLZ:");
        JLabel cityLabel = new JLabel("Stadt:");

        JTextArea hinweisarea = new JTextArea(" Zum Entfernen eines Studenten \n bitte nur dessen Email eingeben\n und denn entsprechenden Button drücken");
        JTextArea hinweisarea2 = new JTextArea();

        studentPanel.add(hinweisarea);
        studentPanel.add(hinweisarea2);
        addressPanel.add(roadLabel);
        road = new JTextField(20);                                          // hier die werte der variablen im fenster eintrage
        addressPanel.add(road);                                                     // die nötig sind um ein schlüssel objekt zu erstellen
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
        JButton cancelButton = new JButton("Zurück");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            for(Student jay : container)        // gibt den Container auf der komandozeile aus (nur zur kontrolle)
                System.out.println(jay);        // final entfernen
            dispose();                          // schliesst fentser
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

          if (!(container.removeStudent(email.getText()))){         // hier wird ein Student aus dem Register zu entfernen
              try {
                  throw new RentalSystemException.EMailNotFound();
              } catch (RentalSystemException.EMailNotFound ex) {   // wirft einen fehler wenn der student nicht vorhanden ist oder die email falsch ist
                  JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                  clear();
                  return;                                         //beendet die Methode
              }
          }

            try(FileWriter wirter = new FileWriter("Student.csv")) {

                for (Student g : container) {                       // geht durch jedes Objekt im container

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

        pack();
    }

    // Methode zum erstellen eines (Studenten)- und (Address)-objekts anhand der eingabe des Nutzers
    private void save() throws IOException, RentalSystemException {

        Address address = new Address(road.getText(), houseNumber.getText(), postalCode.getText(),         //address konstruktor
                city.getText());

        // studenten konstruktor
        Student student = new Student(email.getText(), name.getText(), lastName.getText(), phoneNumber.getText(), address);

        container.addStudent(student);                                                                // hinzufügen des studenten im container

        try(FileWriter writer = new FileWriter("Student.csv", true)) {          // "fügt" denn studenten der CSV datei "Hinzu"
                                                                                                // dafür sorgt das true in new FileWriter
            writer.write(student.toString());                                                   // wäre es nicht da würde immer eine neue datei angelgt/überschrieben
        } catch(IOException e) {
            e.printStackTrace();
        }

        clear();                                                              // Löscht die Eingabe des Useres

    }

    private void clear() {
        name.setText("");                                                    // setzt die eingabefelder zurück
        lastName.setText("");
        email.setText("");
        phoneNumber.setText("");
        road.setText("");
        city.setText("");
        houseNumber.setText("");
        postalCode.setText("");

    }
}
