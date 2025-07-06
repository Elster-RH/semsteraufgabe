import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class addObjekt extends JDialog {


        private GegenstaendeContainer container;
        private Buch buch;
        //private Buch.Condition condition;

        private JTextField kommentar;
        private JTextField bezeichnung;
        private JTextField modNumber;
        private JTextField coindition;


    public addObjekt(Frame parent, GegenstaendeContainer container) {
            super(parent, "Buch hinzufügen", true);
            this.container = container;
            setSize(500, 300);

            JPanel buttonPanel = new JPanel();
            JPanel objektPanel = new JPanel();
            JPanel buchPanel = new JPanel();

            buchPanel.setLayout(new GridLayout(4, 2));

            JLabel kommentarLabel= new JLabel("Kommentar:");
            JLabel bezeichnungLabel = new JLabel("Bezeichnung:");
            JLabel modNumberLabel = new JLabel("Mod Number:");
            JLabel coinditioLabel = new JLabel("Zustand:");

            //JComboBox<Buch.Condition> conditionComboBox = new JComboBox<>(Buch.Condition.values());

            objektPanel.setLayout(new GridLayout(3, 2));
            buchPanel.add(kommentarLabel);
            kommentar = new JTextField();
            buchPanel.add(kommentar);
            buchPanel.add(bezeichnungLabel);
            bezeichnung = new JTextField();
            buchPanel.add(bezeichnung);
            buchPanel.add(modNumberLabel);
            modNumber = new JTextField();
            buchPanel.add(modNumber);
            buchPanel.add(coinditioLabel);
            coindition = new JTextField();
            //buchPanel.add(conditionComboBox);

            JButton addButton = new JButton("Objekt hinzufügen");
            JButton removeButton = new JButton("Objekt entfernen");
            JButton cancelButton = new JButton("Schließen");

            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
            buttonPanel.add(cancelButton);

                cancelButton.addActionListener(e -> {
                    dispose();
                });
                addButton.addActionListener(e -> {

                    //condition = (Buch.Condition) conditionComboBox.getSelectedItem();
                    try {
                        save();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (RentalSystemException ex) {
                        ex.getMessage();
                    }
                });

                add(buttonPanel, BorderLayout.SOUTH);
                add(buchPanel, BorderLayout.NORTH);
            }

            private void save() throws IOException, RentalSystemException {



                buch = new Buch(Gegenstaende.getaktuelleId(), kommentar.getText(), bezeichnung.getText(), modNumber.getText());

                container.addGegenstand(buch);




                try(FileWriter wirter = new FileWriter("Buch.csv", true)) {

                    wirter.write(buch.toString());
                } catch(IOException e) {
                    e.printStackTrace();
                }

                clear();

            }

            private void clear() {
                kommentar.setText("");
                bezeichnung.setText("");
                modNumber.setText("");
                coindition.setText("");
            }
        }