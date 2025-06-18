import javax.swing.*;
import java.awt.*;

public class addObjekt extends JDialog {

    public addObjekt(Frame parent) {
        super(parent, "Objekt hinzufügen", true);
        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel objektPanel = new JPanel();

        objektPanel.setLayout(new GridLayout(3, 2));

        JButton addButton = new JButton("Objekt hinzufügen");
        JButton removeButton = new JButton("Objekt entfernen");
        JButton cancelButton = new JButton("Schließen");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            dispose();
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
