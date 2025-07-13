import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class lentBook extends JDialog  {

    private GegenstaendeContainer container;
    private Buch buch;
    private copyBook copyBook;
    private JTextField pfand = new JTextField();
    private JTextField lentduration = new JTextField();
    private JTextField bookId = new JTextField();
    private JTextField copyId = new JTextField();
    private Student student;
    private JTextField email = new JTextField();

    public lentBook(Frame parent, GegenstaendeContainer container, StudentContainer studentContainer) {
        super(parent, "Buch verleihen", true);
        this.container = container;

        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(5, 2));

        JLabel bookIdLabel = new JLabel("Buch ID:");
        JLabel pfandLabel = new JLabel("Pfand:");
        JLabel lentdurationLabel = new JLabel("Ausleihzeit in Tagen:");
        JLabel copyidLabel = new JLabel("Exemplar Nummer:");
        JLabel emailLabel = new JLabel("Email des Studenten:");

        keyPanel.add(bookIdLabel);
        keyPanel.add(bookId);
        keyPanel.add(copyidLabel);
        keyPanel.add(copyId);
        keyPanel.add(pfandLabel);
        keyPanel.add(pfand);
        keyPanel.add(lentdurationLabel);
        keyPanel.add(lentduration);
        keyPanel.add(emailLabel);
        keyPanel.add(email);

        JButton saveButton = new JButton("Speichern");
        JButton cancelButton = new JButton("Zurück");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        saveButton.addActionListener(e -> {

            buch = container.getBuch(bookId.getText());
            student = studentContainer.getStudent(email.getText());
            copyBook = buch.getCopyBookByNumber(copyId.getText());
            if (student == null) {
                try {
                    throw new RentalSystemException.EMailNotFound();
                } catch (RentalSystemException.EMailNotFound ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                    clear();
                    return;
                }
            }
            copyBook.getLent();
            copyBook.setLentdate();
            copyBook.setLentduration(lentduration.getText());
            copyBook.addStudent(student);
            try {
                copyBook.setPfand(pfand.getText());
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
        bookId.setText("");
        copyId.setText("");
        pfand.setText("");
        lentduration.setText("");
        email.setText("");

    }
}
