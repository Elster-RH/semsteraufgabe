public abstract class Gegenstaende {

        private static int aktuelleId = 0;
        String kommentar;
        String bezeichnung;
        String id;

        public Gegenstaende(String kommentar, String bezeichnung) {

            id = aktuelleId();
            addComment(kommentar);
            setBezeihnung(bezeichnung);

        }


        public String getId(){
            return id;
        }

        public String aktuelleId(){
            aktuelleId++;
            return String.valueOf(aktuelleId);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Schluessel other = (Schluessel) obj;
            return this.getId() == other.getId();
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }




        public void setBezeihnung(String bezeichnung) {
                this.bezeichnung = bezeichnung;
        }

        public String getBezeichnung(){
            return bezeichnung;
        }

        public String getkommentar() {
            return kommentar;
        }

        public void addComment(String comment) {
            if(comment == null){
                System.exit(0);
            }
            this.kommentar = comment;
        }
}
