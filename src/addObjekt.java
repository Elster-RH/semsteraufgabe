import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addObjekt extends JDialog {


        private GegenstaendeContainer container;
        private Buch buch;

        private JTextField kommentar;
        private JTextField title;
        private JTextField amount;


    public addObjekt(Frame parent, GegenstaendeContainer container) {
            super(parent, "Buch hinzufügen", true);
            this.container = container;
            setSize(500, 300);

            JPanel buttonPanel = new JPanel();
            JPanel objektPanel = new JPanel();
            JPanel buchPanel = new JPanel();

            buchPanel.setLayout(new GridLayout(4, 2));

            JLabel kommentarLabel= new JLabel("Kommentar:");
            JLabel titleLabel= new JLabel("Title:");
            JLabel amountLabel= new JLabel("Anzahl:");






            objektPanel.setLayout(new GridLayout(2, 2));
            buchPanel.add(kommentarLabel);
            kommentar = new JTextField();
            buchPanel.add(kommentar);
            buchPanel.add(titleLabel);
            title = new JTextField();
            buchPanel.add(title);
            buchPanel.add(amountLabel);
            amount = new JTextField();
            buchPanel.add(amount);



            JButton addButton = new JButton("Neues Buch anlegen");
            JButton removeButton = new JButton("Test");
            JButton cancelButton = new JButton("Schließen");

            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
            buttonPanel.add(cancelButton);

                cancelButton.addActionListener(e -> {
                    dispose();
                });
                addButton.addActionListener(e -> {

                    int a = Integer.parseInt(amount.getText());

                    try {
                        buch = new Buch(kommentar.getText(), title.getText(), a);
                    } catch (RentalSystemException ex) {
                        throw new RuntimeException(ex);
                    }



                        addcopyBook objekt = new addcopyBook(this, buch, container, a);
                        objekt.setVisible(true);

                        clear();

                });

                add(buttonPanel, BorderLayout.SOUTH);
                add(buchPanel, BorderLayout.NORTH);
            }



            private void clear() {
                kommentar.setText("");
                title.setText("");
                amount.setText("");
            }
        }