import javax.swing.*;
import java.awt.*;

public class BringBack extends JDialog {


    public BringBack(Frame parent,GegenstaendeContainer objContainer, StudentContainer container) {
        super(parent,"Rückgabe", true);
        setSize(200,200);

        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JLabel idLabel = new JLabel("ID:");
        textPanel.add(idLabel);
        JTextField id = new JTextField();
        textPanel.add(id);
        JLabel expLabel = new JLabel("Exempar Nummer:");
        textPanel.add(expLabel);
        JTextField expId = new JTextField();
        textPanel.add(expId);



        JButton okButton = new JButton();
        JButton cancelButton = new JButton();

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        okButton.addActionListener(e -> {

            Buch buch;
            Schluessel key;
            copyBook copyBook;

            key = objContainer.getSchluessel(id.getText());
            buch = objContainer.getBuch(id.getText());



            if(key != null ) {

            }

        });

    }
}
