import javax.swing.*;
import java.awt.*;

public class addObjekt extends JDialog {

    private final CardLayout cardLayout;
    private JPanel cardsPanel;
    private Buch buch;
    private Schluessel schluessel;
    private GegenstaendeContainer GeContainer;


    private JTextField modNumber;
    private JTextField kommentar;
    private JTextField Titel;
    private JComboBox Condition;
    private JTextField schliesst;


    public addObjekt(Frame parent, GegenstaendeContainer container) {
        super(parent, "Objekt hinzufügen", true);
        setSize(500, 300);
        String[] gegenstandTypen = { "Buch", "Schlüssel" };
        this.GeContainer = container;

        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);

        JPanel buttonPanel = new JPanel();

        JLabel bezeichnungtext = new JLabel("Bezeichnung:");
        JLabel modNumbertext = new JLabel("Model/Seriennummer:");
        JLabel schliessttext = new JLabel("Schlüssel schließt::");
        JLabel Titeltext = new JLabel("Buchtitel:");
        JLabel Conditiontext = new JLabel("Condition:");
        JLabel Kommentartext = new JLabel("Kommentar:");

        JPanel objektPanel = new JPanel();
        objektPanel.setLayout(new GridLayout(3, 2));


        objektPanel.add(bezeichnungtext);
        JComboBox<String> bezeichnung = new JComboBox<>(gegenstandTypen);
        objektPanel.add(bezeichnung);
        add(objektPanel, BorderLayout.NORTH);

        objektPanel.add(Kommentartext);
        kommentar = new JTextField(20);
        objektPanel.add(kommentar);

        JPanel buchPanel = new JPanel();
        buchPanel.setLayout(new GridLayout(2, 2));

        buchPanel.add(modNumbertext);
        modNumber = new JTextField(20);
        buchPanel.add(modNumber);

        buchPanel.add(Titeltext);
        Titel = new JTextField(20);
        buchPanel.add(Titel);

        JPanel schluesselPanel = new JPanel();
        schluesselPanel.setLayout(new GridLayout(1, 2));

        schluesselPanel.add(schliessttext);
        schliesst =  new JTextField(20);
        schluesselPanel.add(schliesst);

        buchPanel.add(Conditiontext);
        JComboBox<Buch.Condition> conditionComboBox = new JComboBox<>(Buch.Condition.values());
        buchPanel.add(conditionComboBox);

        add(cardsPanel, BorderLayout.CENTER);
        cardsPanel.add(buchPanel, "Buch");
        cardsPanel.add(schluesselPanel, "Schlüssel");

         bezeichnung.addActionListener(e -> {
             String selected = (String) bezeichnung.getSelectedItem();
             if("Buch".equals(selected)) {
                 cardLayout.show(cardsPanel, "Buch");
             }else if("Schlüssel".equals(selected)) {
                 cardLayout.show(cardsPanel, "Schlüssel");
             }
         }) ;


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
