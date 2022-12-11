class Collatz {
    public static void main(String args[]){
        // wenn n und m gegeben sind
        if (args.length == 2) {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            // Vorraussetzungen aus Aufgabe
            if (n <= 0 || m <= 0 || n > m) {
                System.out.println("Ungültige Eingabe");
                return;
            }
            // Funktion im Intervall [n, m] aufrufen und Ergebnis ausgeben
            for (int i = n; i <= m; i++) {
                int[] Array = collatzIterativ(i);
                for (int j = 0; j<Array.length; j++) {
                    System.out.print(Array[j] + ", ");
                }
                System.out.println();
            }
        }

        // wenn nur n gegeben ist
        else if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.out.println("Ungültige Eingabe");
                return;
            }
            // Beide Funktionen nur ein mal für n aufrufen
            collatzIterativOutput(n);
            int[] Array = collatzIterativ(n);
            for (int i= 0; i<Array.length; i++) {
                System.out.print(Array[i] + ", ");
            }
            System.out.println();
        }
        // Vorraussetzungen der Aufgabe
        else {
            System.out.println("Es müssen entweder eine oder zwei Zahlen eingegeben werden");
            return;
        }
    }


    static void collatzIterativOutput(int n) {
        int i = 0;
        System.out.println("a" + i + ": " + n);
        while (n != 1 && n != Integer.MAX_VALUE && i != Integer.MAX_VALUE) {
            if (n % 2 == 0) {
                n = n / 2; }
            else if (n % 2 == 1) {
                n = 3 * n + 1; }
            i += 1;
            // i und a jede Wiederholungen ausgeben
            System.out.println("a" + i + ": " + n);
        }
    }


    static int [] collatzIterativ(int n) {
        int[] values = {n};
        // i überprüft, dass nur von n bis m gelaufen wird
        while (n != 1 && n != Integer.MAX_VALUE) {
            if (n % 2 == 0) {
                n = n / 2; }
            else if (n % 2 == 1) {
                n = 3 * n + 1; }
            // values wird mit neuem Wert überschrieben
            values = appendInt(values, n);
        }
        return values;
    }


    public static int[] appendInt(int[] a, int b) {
        // neues array , das 1 länger ist als a
        int[] arr = new int[a.length + 1];
        // alle Werte aus a in arr übernehmen
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        // letzten Wert b zu arr hinzufügen
        arr[a.length] = b;

        // arr (neues längeres Array) zurückgeben
        return arr;
    }

}