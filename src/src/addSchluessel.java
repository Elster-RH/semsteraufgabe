import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addSchluessel extends JDialog {

    private GegenstaendeContainer container;
    private Schluessel key;
    private Student student;

    private JTextField kommentar;
    private JTextField Schliesst;


    public addSchluessel(Frame parent, GegenstaendeContainer container) throws HeadlessException {
        super(parent, "Schlüssel hinzufügen", true);
        this.container = container;
        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();

        JLabel kommentarLabel = new JLabel("Kommentar:");
        JLabel bezeichnungLabel = new JLabel("Für das Schloß:");

        keyPanel.setLayout(new GridLayout(2,2));
        keyPanel.add(kommentarLabel);
        kommentar = new JTextField();
        keyPanel.add(kommentar);
        keyPanel.add(bezeichnungLabel);
        Schliesst = new JTextField();
        keyPanel.add(Schliesst);

        JButton addButton = new JButton("Schlüssel hinzufügen");
        JButton cancelButton = new JButton("Schließen");

        addButton.addActionListener(e -> {

            try {
                save();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Schreiben der Datei:\n" + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            } catch (RentalSystemException.EmptyField ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }

        });
        cancelButton.addActionListener(e -> {
            for(Gegenstaende jay : container)
                System.out.println(jay);
            dispose();
        });
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(keyPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

    }


    private void save() throws IOException, RentalSystemException.EmptyField {

        System.out.println("Speichern abgeschlossen.");

        key = new Schluessel(kommentar.getText(), Schliesst.getText());
        System.out.println("2");

        container.addGegenstand(key);
        System.out.println("3");




        try(FileWriter wirter = new FileWriter("Buch.csv", true)) {

            wirter.write(key.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }

        clear();

    }

    private void clear() {
        kommentar.setText("");
        Schliesst.setText("");

    }

}
