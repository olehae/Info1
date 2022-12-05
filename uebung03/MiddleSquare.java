class MiddleSquare {
        public static void main(String args[]){
                int a = 0;
                while(true) {
                        StdOut.println("Enter the number:");
                        a = StdIn.readInt();
                        if (a<0 || a>=100) {
                                StdOut.println("invalid number");
                                continue;
                        }
                        break;
                }
                int temp = 0;
                for (int i = 0; i<101; i++) {
                        temp = a;                       // temporäre variable, damit alles in eine Zeile geprintet werden kann
                        a = a*a;                        // a quadrieren
                        StdOut.println("Iteration "+(i+1)+": "+temp+"*"+temp+" = "+a);  // a ausgeben
                        if (a == 0) {
                                StdOut.println("You have reached a = 0 after "+(i+1)+" iterations");
                                break; }
                        // a aktualisieren
                        else if (a<10) {
                                a = 0; }                // zB asq = 0009 -> a = 00 = 0
                        else if ((9<a) && (a<1000)) {
                                a = a/10; }             // zB asq = 123 -> a = 12
                        else if ((999<a) && (a<10000)) {
                                a = a/10;               // zB asq = 1234 -> a = 123
                                a = a%100; }            // siehe obere Zeile -> a = 123 % 100 = 23
                }
        }
}