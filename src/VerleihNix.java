import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VerleihNix extends JFrame {

    public VerleihNix(StudentContainer container, GegenstaendeContainer objContainer) {

        setTitle("VerleihNix");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextArea hinweisarea = new JTextArea("Willkommen bei Verleihnix ihrem Experten \n wenn es ums Verleihen geht.\nUms Wiederbekommen müssen Sie sich selbst kümmern.");


        JButton studentbutton = new JButton("Neuen Studenten anlegen");
        JButton bookbutton = new JButton("Neues Buch anlegen");
        JButton keyButton = new JButton("Neuen Schlüssel anlegen");
        JButton closebutton = new JButton("Beenden");
        JButton lentkeybutton = new JButton("Schlüssel verleihen");
        JButton lentBookbutton = new JButton("Buch verleihen");
        JButton backButton = new JButton("Zurückgeben");
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

        });
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(hinweisarea);


        add(buttonPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        pack();


        setVisible(true);

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

        try (BufferedReader in2 = new BufferedReader(new FileReader("Buch.csv"))) {
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




                }else if (data[0].contains("buch")) {

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

                        //andere Methode
                    /*for(int i = 5; i < 5 + (amount * 6); i = i + 6){
                        if(data[i + 1].contains("null")) {
                            String modNum = data[i];
                            String lentdate = data[i + 2];
                            String lentduration = data[i + 3];
                            String pfand = data[i + 4];
                            copyBook.Condition cond = copyBook.Condition.valueOf(data[i + 5]);

                            try{
                                copy = new copyBook(modNum, lentdate, lentduration, pfand, cond);
                            } catch (RentalSystemException e) {
                                throw new RuntimeException(e);
                            }
                        }else {
                            String modNum = data[i];
                            String eMail = data[i + 1];
                            String lentdate = data[i + 2];
                            String lentduration = data[i + 3];
                            String pfand = data[i + 4];
                            copyBook.Condition cond = copyBook.Condition.valueOf(data[i + 5]);
                            Student student = container.getStudent(eMail);

                            try{
                                copy = new copyBook(modNum, student, lentdate, lentduration, pfand, cond);
                            } catch (RentalSystemException e) {
                                throw new RuntimeException(e);
                            }
                        }*/
                        try {
                            buch.addCopy(copy);
                        }catch (RentalSystemException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    objContainer.addGegenstand(buch);
                }



            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new VerleihNix(container, objContainer);

    }
}
