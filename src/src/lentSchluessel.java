import javax.swing.*;
import java.awt.*;

public class lentSchluessel extends JDialog  {

    private GegenstaendeContainer container;
    private Schluessel key;
    private JTextField pfand = new JTextField();
    private JTextField lentduration = new JTextField();
    private JTextField keyId = new JTextField();

    public lentSchluessel(Frame parent, GegenstaendeContainer container) {
        super(parent, "Schluessel verleihen", true);
        this.container = container;

        setSize(500, 300);

        JPanel buttonPanel = new JPanel();
        JPanel keyPanel = new JPanel();

        JLabel keyIdLabel = new JLabel("Schlüssel ID:");
        JLabel pfandLabel = new JLabel("Pfand:");
        JLabel lentdurationLabel = new JLabel("Ausleihzeit in Tagen:");

        keyPanel.add(keyIdLabel);
        keyPanel.add(keyId);
        keyPanel.add(pfandLabel);
        keyPanel.add(pfand);
        keyPanel.add(lentdurationLabel);
        keyPanel.add(lentduration);

        JButton saveButton = new JButton("Speicher");
        JButton cancelButton = new JButton("Schliessen");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        key = container.getSchluessel(keyId.getText());



    }
}
