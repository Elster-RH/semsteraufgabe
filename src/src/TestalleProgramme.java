public class TestalleProgramme {
    public static void main(String[] args) {

        System.out.println("\nProgramm laeuft");

        Address A1 = new Address(" BaumStr.", 13, 55672, "Auxburg");
        Student S1 = new Student( "www.TimHuber@gmx.de", "Tim","Huber", A1, "+49 111 235 874" );


        System.out.println(S1);
    }
}
