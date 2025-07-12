import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class addcopyBook extends JDialog {

    GegenstaendeContainer container;

    private JTextField modNumber = new JTextField();
    private copyBook.Condition condition;

    public addcopyBook(addObjekt parent, Buch buch, GegenstaendeContainer container, int n) {
        super(parent, "Bücher anlegen", true);

        final int[] clickCount = {0};


        this.container = container;

        setSize(500, 300);

        JPanel copyBookpanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        copyBookpanel.setLayout(new BoxLayout(copyBookpanel, BoxLayout.X_AXIS));

        JButton addButton = new JButton("Exemplar hinzufügen:");
        JButton saveButton = new JButton("Speichern");

        JLabel modNumberLabel = new JLabel("Mod Number:");
        JLabel coinditioLabel = new JLabel("Zustand:");

        copyBookpanel.add(coinditioLabel);
        JComboBox<copyBook.Condition> conditionComboBox = new JComboBox<>(copyBook.Condition.values());
        copyBookpanel.add(conditionComboBox);

        copyBookpanel.add(modNumberLabel);
        copyBookpanel.add(modNumber);

        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);

        addButton.addActionListener(e -> {

            if (clickCount[0] == n) {
                JOptionPane.showMessageDialog(this, "Maximale Anzahl an Exemplaren erreicht");
                return;
            }

            condition = (copyBook.Condition) conditionComboBox.getSelectedItem();

            try {
                save(buch);
            } catch (RentalSystemException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }

            clickCount[0]++;
        });

        saveButton.addActionListener(e -> {

            container.addGegenstand(buch);

            try(FileWriter wirter = new FileWriter("Buch.csv")) {

                for (Gegenstaende g : container) {

                    wirter.write(g.toString());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Speichern der Daten:\n" + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }

            dispose();

        });

        add(copyBookpanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);


    }

    private void save(Buch buch) throws  RentalSystemException {

        copyBook copy = new copyBook(modNumber.getText(), condition);

        buch.addCopy(copy);

        clear();

    }

    private void clear() {
        modNumber.setText("");
    }
}
