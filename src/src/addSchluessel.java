import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addSchluessel extends JDialog {

    private GegenstaendeContainer container = new GegenstaendeContainer();
    private Schluessel key;
    private Student student;

    private JTextField kommentar;
    private JTextField bezeichnung;


    public addSchluessel(Frame parent, GegenstaendeContainer container) throws HeadlessException {
        super(parent, "Schlüssel hinzufügen", true);
        this.container = container;
        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();

        JLabel kommentarLabel = new JLabel("Kommentar:");
        JLabel bezeichnungLabel = new JLabel("Bezeichnung:");

        keyPanel.setLayout(new FlowLayout());
        keyPanel.add(kommentarLabel);
        kommentar = new JTextField();
        keyPanel.add(kommentar);
        keyPanel.add(bezeichnungLabel);
        bezeichnung = new JTextField();
        keyPanel.add(bezeichnung);

        JButton addButton = new JButton("Schlüssel hinzufügen");
        JButton cancelButton = new JButton("Schließen");

        addButton.addActionListener(e -> {

            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (RentalSystemException ex) {
                ex.getMessage();
            }

        });
        cancelButton.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(keyPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

    }


    private void save() throws IOException, RentalSystemException {



        key = new Schluessel(kommentar.getText(), bezeichnung.getText());

        container.addGegenstand(key);




        try(FileWriter wirter = new FileWriter("Buch.csv", true)) {

            wirter.write(key.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }

        clear();

    }

    private void clear() {
        kommentar.setText("");
        bezeichnung.setText("");

    }

}
