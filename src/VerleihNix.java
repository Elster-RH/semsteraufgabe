import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Iterator;

public class VerleihNix extends JFrame {

    public VerleihNix(StudentContainer container, GegenstaendeContainer objContainer) {

        setTitle("VerleihNix");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel eastPanel = new JPanel();

        northPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        eastPanel.setLayout(new GridLayout(2,1));

        JTextArea hinweisarea = new JTextArea("Willkommen bei Verleihnix ihrem Experten wenn  \nes ums Verleihen geht. Ums Wiederbekommen \nmüssen Sie sich selbst kümmern.");


        JButton studentbutton = new JButton("Neuen Studenten anlegen");
        JButton bookbutton = new JButton("Neuen Gegenstand anlegen");
        JButton keyButton = new JButton("Neuen Schlüssel anlegen");
        JButton closebutton = new JButton("Beenden");
        JButton lentkeybutton = new JButton("Schlüssel verleihen");
        JButton lentBookbutton = new JButton("Gebenstand verleihen");
        JButton backButton = new JButton("Zurückgeben");
        JButton printButton = new JButton("Erstelle Liste Ausgeliehene");
        JButton printUButton = new JButton("Erstelle Liste Überzogene");
        eastPanel.add(printButton);
        eastPanel.add(printUButton);
        buttonPanel.add(studentbutton);
        buttonPanel.add(keyButton);
        buttonPanel.add(bookbutton);
        buttonPanel.add(closebutton);
        northPanel.add(lentkeybutton);
        northPanel.add(lentBookbutton);
        northPanel.add(backButton);


        closebutton.addActionListener(e -> {
            dispose();
        });
        studentbutton.addActionListener(e -> {
            addStudent student = new addStudent(this, container);
            student.setVisible(true);
        });
        bookbutton.addActionListener(e -> {
            addObjekt objekt = new addObjekt(this, objContainer);
            objekt.setVisible(true);
        });
        keyButton.addActionListener(e -> {
            addSchluessel key = new addSchluessel(this, objContainer);
            key.setVisible(true);
        });
        lentkeybutton.addActionListener(e -> {
            lentSchluessel lentkey = new lentSchluessel(this, objContainer, container);
            lentkey.setVisible(true);
        });
        lentBookbutton.addActionListener(e -> {
            lentBook lentBook = new lentBook(this, objContainer, container);
            lentBook.setVisible(true);
        });
        backButton.addActionListener(e -> {
            BringBack back = new BringBack(this, objContainer);
            back.setVisible(true);

        });
        printButton.addActionListener(e -> {
            printall(objContainer);
            AnzeigeListeAusgeliehen();
        });
        printUButton.addActionListener(e -> {
            ToLate(objContainer);
            AnzeigeListeUeberzogene();
        });
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(hinweisarea);


        add(buttonPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);

        pack();


        setVisible(true);

    }

    public void printall(GegenstaendeContainer objContainer) {

        try(FileWriter wirter = new FileWriter("Alle_ausgeliehen_Gegenstaende.csv")) {

            StringBuilder be = new StringBuilder();

            for (Gegenstaende g : objContainer) {

                if (g.getBezeichnung().contains("schluesse")) {
                    Schluessel key = (Schluessel) g;
                    Student student = key.getStudent();
                    if (!(key.checkLent())) {
                        be.setLength(0);
                        be.append("Bezeichnung:").append(key.getBezeichnung()).append("\n")
                                .append("Angefügter Kommentar:").append(key.getkommentar()).append("\n")
                                .append("Schliesst:").append(key.getSchliesst()).append("\n")
                                .append("Hinterlegtes Pfand:").append(key.getPfand()).append("\n")
                                .append("Ausgeliehen seit:").append(key.getLentdate()).append("\n")
                                .append("Ausgeliehen bis:").append(key.getLentduration()).append("\n")
                                .append("Ausgeliehen von:").append(student.geteMail()).append("\n")
                                .append("\n");

                        wirter.write(be.toString());
                    }
                }
                if (g.getBezeichnung().contains("gegenstand")) {
                    Buch buch = (Buch) g;
                    copyBook copy;
                    Student student;
                    int n = buch.getAmount();
                    for (int i = 1; i <= n; i++) {
                        String s = Integer.toString(i);
                        copy = buch.getCopyBookByNumber(s);
                        student = copy.getStudent();

                        if (!(copy.getLent())) {
                            be.setLength(0);
                            be.append("Bezeichnung:").append(buch.getBezeichnung()).append("\n")
                                    .append("Angefügter Kommentar:").append(buch.getkommentar()).append("\n")
                                    .append("Titel:").append(buch.getTitle()).append("\n")
                                    .append("Exemplar Nummer").append(copy.getModNumber()).append("\n")
                                    .append("Hinterlegtes Pfand:").append(copy.getPfand()).append("\n")
                                    .append("Ausgeliehen seit:").append(copy.getLentDate()).append("\n")
                                    .append("Ausgeliehen bis:").append(copy.getLentduration()).append("\n")
                                    .append("Ausgeliehen von:").append(student.geteMail()).append("\n")
                                    .append("\n");

                            wirter.write(be.toString());
                        }
                    }
                }

            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ToLate(GegenstaendeContainer objContainer) {

        try(FileWriter wirter = new FileWriter("Alle_ausgeliehen_und_Überzogene_Gegenstaende.csv")) {

            StringBuilder be = new StringBuilder();

            for (Gegenstaende g : objContainer) {

                if (g.getBezeichnung().contains("schluessel")) {
                    Schluessel key = (Schluessel) g;
                    Student student = key.getStudent();
                    if (!(key.checkLent())) {

                        if (key.checklentdate()) {
                            be.setLength(0);
                            be.append("ÜBERZOGEN!!!").append("\n")
                                    .append("Bezeichnung:").append(key.getBezeichnung()).append("\n")
                                    .append("Angefügter Kommentar:").append(key.getkommentar()).append("\n")
                                    .append("Schliesst:").append(key.getSchliesst()).append("\n")
                                    .append("Hinterlegtes Pfand:").append(key.getPfand()).append("\n")
                                    .append("Ausgeliehen seit:").append(key.getLentdate()).append("\n")
                                    .append("Ausgeliehen bis:").append(key.getLentduration()).append("\n")
                                    .append("Ausgeliehen von:").append(student.geteMail()).append("\n")
                                    .append("\n");

                            wirter.write(be.toString());
                        }
                    }
                }
                if (g.getBezeichnung().contains("gegenstand")) {
                    Buch buch = (Buch) g;
                    copyBook copy;
                    Student student;
                    int n = buch.getAmount();
                    for (int i = 1; i <= n; i++) {
                        String s = Integer.toString(i);
                        copy = buch.getCopyBookByNumber(s);
                        student = copy.getStudent();


                        if (!(copy.getLent())) {
                            if (copy.checklentdate()) {
                                be.setLength(0);
                                be.append("ÜBERZOGEN!!!").append("\n")
                                        .append("Bezeichnung:").append(buch.getBezeichnung()).append("\n")
                                        .append("Angefügter Kommentar:").append(buch.getkommentar()).append("\n")
                                        .append("Titel:").append(buch.getTitle()).append("\n")
                                        .append("Exemplar Nummer").append(copy.getModNumber()).append("\n")
                                        .append("Hinterlegtes Pfand:").append(copy.getPfand()).append("\n")
                                        .append("Ausgeliehen seit:").append(copy.getLentDate()).append("\n")
                                        .append("Ausgeliehen bis:").append(copy.getLentduration()).append("\n")
                                        .append("Ausgeliehen von:").append(student.geteMail()).append("\n")
                                        .append("\n");

                                wirter.write(be.toString());
                            }
                        }
                    }
                }

            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) {

        StudentContainer container = new StudentContainer();
        GegenstaendeContainer objContainer = new GegenstaendeContainer();


        try (BufferedReader in1 = new BufferedReader(new FileReader("Student.csv"))) {
            String zeile;

            while ((zeile = in1.readLine()) != null) {

                String[] data = zeile.split(";");

                Address address;
                Student student;

                if (data.length == 8) {
                    String road = data[0];
                    String houseNumber = data[1];
                    String postCode = data[2];
                    String city = data[3];

                    try {
                        address = new Address(road, houseNumber, postCode, city);

                    } catch (RentalSystemException ex) {
                        throw new RuntimeException(ex);
                    }

                    String eMail = data[4];
                    String firstName = data[5];
                    String lastName = data[6];
                    String phoneNumber = data[7];

                    try {
                        student = new Student(eMail, firstName, lastName, phoneNumber, address);
                    } catch (RentalSystemException e) {
                        throw new RuntimeException(e);
                    }
                    try{
                        container.addStudent(student);
                    } catch (RentalSystemException.EmailAlreadyExists e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in2 = new BufferedReader(new FileReader("Gegenstaende.csv"))) {
            String zeile;


            while ((zeile = in2.readLine()) != null) {

                String[] data = zeile.split(";");

                Schluessel key;

                if (data[0].contains("schluessel")) {

                    if (data[4].contains("null")) {
                        String comm = data[2];
                        String schliesst = data[3];
                        String pfand = data[5];
                        String lentdate = data[6];
                        String lentduration = data[7];


                        try {
                            key = new Schluessel(comm, schliesst, pfand, lentdate, lentduration);
                        } catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                        objContainer.addGegenstand(key);
                    } else {


                        String comm = data[2];
                        String schliesst = data[3];
                        String pfand = data[5];
                        String lentdate = data[6];
                        String lentduration = data[7];
                        String eMail = data[4];

                        Student student = container.getStudent(eMail);

                        try {
                            key = new Schluessel(comm, schliesst, student, pfand, lentdate, lentduration);
                        } catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                        objContainer.addGegenstand(key);
                    }




                }else if (data[0].contains("gegenstand")) {

                    String comm = data[2];
                    String title = data[3];
                    int amount = Integer.parseInt(data[4]);

                    copyBook copy;
                    Buch buch;

                    try {
                        buch = new Buch(comm, title, amount);
                    }catch (RentalSystemException e) {
                        throw new RuntimeException(e);
                    }




                    for (int i = 0; i < amount; i++) {
                        try {
                            zeile = in2.readLine();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                        String[] data1 = zeile.split(";");

                        if(data1[1].contains("null")) {

                            String modNum = data1[0];
                            String lentdate = data1[2];
                            String lentduration = data1[3];
                            String pfand = data1[4];
                            copyBook.Condition cond = copyBook.Condition.valueOf(data1[5]);

                            try{
                                copy = new copyBook(modNum, lentdate, lentduration, pfand, cond);
                            } catch (RentalSystemException e) {
                                throw new RuntimeException(e);
                            }
                        }else {
                            String modNum = data1[0];
                            String eMail = data1[1];
                            String lentdate = data1[2];
                            String lentduration = data1[3];
                            String pfand = data1[4];
                            copyBook.Condition cond = copyBook.Condition.valueOf(data1[5]);
                            Student student = container.getStudent(eMail);

                            try{
                                copy = new copyBook(modNum, student, lentdate, lentduration, pfand, cond);
                            } catch (RentalSystemException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        try {
                            buch.addCopy(copy);
                        }catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    objContainer.addGegenstand(buch);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        new VerleihNix(container, objContainer);

    }
    public void AnzeigeListeAusgeliehen() {
        StringBuilder inhalt = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Alle_ausgeliehen_Gegenstaende.csv"))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                inhalt.append(zeile).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen der Datei: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTextArea textArea = new JTextArea(inhalt.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Alle ausgeliehenen Gegenstände", JOptionPane.INFORMATION_MESSAGE);
    }
    public void AnzeigeListeUeberzogene() {
        StringBuilder inhalt = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Alle_ausgeliehen_und_Überzogene_Gegenstaende.csv"))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                inhalt.append(zeile).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen der Datei: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JTextArea textArea = new JTextArea(inhalt.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Alle_ausgeliehen_und_Überzogene_Gegenstaende.csv", JOptionPane.INFORMATION_MESSAGE);
    }
}
