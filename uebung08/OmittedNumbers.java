public class OmittedNumbers {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte nur eine Nummer als Maximum eingeben");
        }
        else {
            int n = Integer.parseInt(args[0]); // Integer von Kommandozeile
            boolean[] arr = new boolean[n]; // jeder Wert wird als false initalisiert
            int step_length = 2; // fängt bei 2 an und zählt hoch
            int omitted = n; // Anzahl der ausgelassenen Nummern
            int counter = 0; 
            while (step_length <= omitted) { // wenn step_length < omitted wird keine Nummer mehr ausgwählt werden
                for (int i=0; i<arr.length; i++) { // über array iterieren  
                    if (!arr[i]) {
                        counter += 1; // counter wird nur omitted numbers erhöht
                    }
                    if (counter == step_length) {
                        arr[i] = true; // arr position auf true setzem
                        omitted -= 1; 
                        counter = 0; // counter reset
                    }
                }
                step_length++; // für neuen Durchlauf
                counter = 0; // counter reset
            }
            for (int i=0; i<arr.length; i++) {
                if (!arr[i]) { // wenn der Wert an Stelle i false ist
                    System.out.println(i+1); // i+1 weil arr bei 0 anfängt
                }
            }
        }
    }   
}