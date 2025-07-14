import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class BringBack extends JDialog {


    private JTextField copyId = new JTextField();
    private JTextField id = new JTextField();


    public BringBack(Frame parent,GegenstaendeContainer objContainer) {
        super(parent,"Rückgabe", true);
        setSize(600,600);

        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        textPanel.setLayout(new GridLayout(2,2));

        JLabel idLabel = new JLabel("ID:");
        textPanel.add(idLabel);
        textPanel.add(id);
        JLabel expLabel = new JLabel("Exempar Nummer:");
        textPanel.add(expLabel);
        textPanel.add(copyId);



        JButton okButton = new JButton("Zurückgeben");
        JButton cancelButton = new JButton("Zurück");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        okButton.addActionListener(e -> {

            Buch buch;
            Schluessel key;
            copyBook copyBook;

            key = objContainer.getSchluessel(id.getText());
            buch = objContainer.getBuch(id.getText());




            if(key != null ) {
                try {
                    key.checklentdate();
                }catch (RentalSystemException e1) {
                    JOptionPane.showMessageDialog(this,e1.getMessage());
                }

                key.bringBack();
            }

            if (buch != null) {
                copyBook = buch.getCopyBookByNumber(copyId.getText());
                try {
                    copyBook.checklentdate();
                }catch (RentalSystemException e1) {
                    JOptionPane.showMessageDialog(this,e1.getMessage());
                }

                copyBook.bringBack();
            }

            try(FileWriter wirter = new FileWriter("Buch.csv")) {

                for (Iterator<Gegenstaende> it = objContainer.iterator(); it.hasNext(); ) {

                    Gegenstaende g = it.next();
                    wirter.write(g.toString());
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }

            clear();

        });

        cancelButton.addActionListener(e -> {
            dispose();
        });

        add(textPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);

        pack();

    }

    public void clear(){

        id.setText("");
        copyId.setText("");
    }
}
