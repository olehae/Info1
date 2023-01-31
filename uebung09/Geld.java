public class Geld {
    private int euro, cent;

    // Konstruktor
    public Geld(int e, int c) {
        euro = splitcents(c)[0];
        euro += e;
        cent = splitcents(c)[1];
    }
    private int[] splitcents(int c) {
        int[] result = new int[2];
        // wenn c >= 100, muss der Centbetrag aufgeteilt werden
        if (c >= 100) {
            result[1] = c % 100;
            result[0] = (c - result[1]) / 100;
            return result;
        }
        // wenn c < 100 ist alles ok
        else {
            result[1] = c;
            result[0] = 0;
            return result;
        }
    }
    public boolean equals(Geld g) {
        // Vergleiche die Euro und die Cent Beträge
        if ((this.euro == g.euro) && (this.cent == g.cent)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void add(Geld g) {
        // Zuerst Cent Beträge addieren, falls sie auf >= 100 kommen
        int c = cent + g.cent;
        euro += splitcents(c)[0];
        euro += g.euro;
        cent = splitcents(c)[1];
    }
    public String toString() {
        String result = "";
        // Ohne diese Unterschiedung würde 1 Euro 6 Cent als 1,6 Euro geschrieben werden
        if (cent < 10) {
            result = euro + ",0" + cent + " Euro";
        }
        else {
            result = euro + "," + cent + " Euro";
        }
        return result;
    }
    private static void test() {
        // Alle Funktionen mit beliebigen Variablen testen
        Geld betrag1 = new Geld(4, 150);
        Geld betrag2 = new Geld(3, 50);
        System.out.print("betrag1 Geld(4, 150): ");
        System.out.println(betrag1);
        System.out.print("betrag2 Geld(3, 50): ");
        System.out.println(betrag2);
        betrag1.add(betrag2);
        System.out.print("betrag1.add(betrag2) ");
        System.out.println(betrag1);
    }
    public static void main(String[] args) {
        test();
    }
}