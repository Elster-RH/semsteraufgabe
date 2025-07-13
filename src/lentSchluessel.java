import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class lentSchluessel extends JDialog  {

    private GegenstaendeContainer container;
    private Schluessel key;
    private JTextField pfand = new JTextField();
    private JTextField lentduration = new JTextField();
    private JTextField keyId = new JTextField();
    private Student student;
    private JTextField email = new JTextField();

    public lentSchluessel(Frame parent, GegenstaendeContainer container, StudentContainer studentContainer) {
        super(parent, "Schluessel verleihen", true);
        this.container = container;

        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(4, 2));

        JLabel keyIdLabel = new JLabel("Schlüssel ID:");
        JLabel pfandLabel = new JLabel("Pfand:");
        JLabel lentdurationLabel = new JLabel("Ausleihzeit in Tagen:");
        JLabel emailLabel = new JLabel("Email des Studenten:");

        keyPanel.add(keyIdLabel);
        keyPanel.add(keyId);
        keyPanel.add(pfandLabel);
        keyPanel.add(pfand);
        keyPanel.add(lentdurationLabel);
        keyPanel.add(lentduration);
        keyPanel.add(emailLabel);
        keyPanel.add(email);

        JButton saveButton = new JButton("Speicher");
        JButton cancelButton = new JButton("Schliessen");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        saveButton.addActionListener(e -> {

            key = container.getSchluessel(keyId.getText());
            student = studentContainer.getStudent(email.getText());
            if (student == null) {
                try {
                    throw new RentalSystemException.EMailNotFound();
                } catch (RentalSystemException.EMailNotFound ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                    clear();
                    return;
                }
            }
            try {
                key.getLent();
            }catch(RentalSystemException.NotAvailable ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
            key.setLentdate();
            key.setLentduration(lentduration.getText());
            key.addStudent(student);
            try {
                key.setPfand(pfand.getText());
            }catch(RentalSystemException.EmptyField ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }

            try(FileWriter wirter = new FileWriter("Buch.csv")) {

                for (Iterator<Gegenstaende> it = container.iterator(); it.hasNext(); ) {

                    Gegenstaende g = it.next();
                    wirter.write(g.toString());
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }

            clear();

        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(keyPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);





    }

    private void clear() {
        keyId.setText("");
        pfand.setText("");
        lentduration.setText("");
        email.setText("");

    }
}
