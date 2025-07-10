import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addSchluessel extends JDialog {

    private GegenstaendeContainer container;

    private JTextField kommentar;
    private JTextField Schliesst;


    public addSchluessel(Frame parent, GegenstaendeContainer container) throws HeadlessException {
        super(parent, "Schlüssel hinzufügen", true); // erstelle Fenster um ein schlüssel-objekt hinzuzufügen
        this.container = container;
        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();

        JLabel kommentarLabel = new JLabel("Kommentar:");
        JLabel bezeichnungLabel = new JLabel("Für das Schloß:");

        keyPanel.setLayout(new GridLayout(2,2));
        keyPanel.add(kommentarLabel);
        kommentar = new JTextField();        // hier die werte der variablen im fenster eintrage
        keyPanel.add(kommentar);             // die nötig sind um ein schlüssel objekt zu erstellen
        keyPanel.add(bezeichnungLabel);
        Schliesst = new JTextField();
        keyPanel.add(Schliesst);

        JButton addButton = new JButton("Schlüssel hinzufügen");
        JButton cancelButton = new JButton("Schließen");

        addButton.addActionListener(e -> { // Button zu hinzufügen eines Schlüssels

            try {
                save(); // speichermethode
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Schreiben der Datei:\n" + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            } catch (RentalSystemException.EmptyField ex) {
                ex.printStackTrace();
                // JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);

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
        cancelButton.addActionListener(e -> {
            for(Gegenstaende jay : container) // gibt den Container auf der komandozeile aus (nur zur kontrolle)
                System.out.println(jay);      // final entfernen
            dispose();                        // schliesst fentser
        });
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(keyPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

    }


    // Methode zum erstellen eines (schlüssel) objekts anhand der eingabe des Nutzers
    private void save() throws IOException, RentalSystemException.EmptyField {

        Schluessel key = new Schluessel(kommentar.getText(), Schliesst.getText()); // schlüssel konstruktor

        container.addGegenstand(key);                                             // Fügt schlüssel zu container hinzu

        try(FileWriter wirter = new FileWriter("Buch.csv", true)) {  // Methode zum hinzufügen des angelegten
                                                                                     // Schlüssels zu der CSV Datei. arbeitet mit der
            wirter.write(key.toString());                                            // toString-Methode des Objekts

        } catch(IOException e) {
            e.printStackTrace();
        }

        clear();                                                                    // Löscht die Eingabe des Useres

    }

    private void clear() {
        kommentar.setText("");                                                     // setzt die eingabefelder zurück
        Schliesst.setText("");

    }

}
