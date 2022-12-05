public class HexMiddleSquare {
        public static void main(String args[]) {
                long a = 0;
                while(true) {
                        System.out.println("Enter the number:");
                        a = StdIn.readLong();
                        if (a<0x1000 || a>0xFFFF) {
                                System.out.println("invalid number");
                                continue; }
                        break;
                }
                long[] igel = new long[0x10000]; // Worst case an Wiederholungen, bis Zyklus gefunden wird
                long[] hase = new long[0x5000];
                // Arrays für Aufgabenteil 2.2)

                int hcount = 0; // listenindex von Hase
                int icount = 0; // listenindex von Igel
                Boolean run = true;

                while (run) {
                        System.out.print(a+" * "+a+" = ");
                        a = a*a;
                        System.out.println(a);
                        igel[icount] = a;                       // Aktualisieren Igel

                        if (icount%2 == 0) { // gerade Zahl -> es wird jedes zweite mal ausgeführt
                                System.out.println("Igel "+(icount)+" \t Hase "+(hcount));
                                hase[hcount] = a;       // Aktualisieren Hase
                                if (igel[hcount] == hase[hcount] && hcount != 0) { // Vergleich bei gleicher Schrittlänge
                                        System.out.println("\nGleiche Werte bei "+(hcount));
                                        if (igel[hcount] != igel[hcount+1]) {
                                                System.out.println("Zyklus ist länger als 1"); }
                                        run = false; }
                                hcount += 1;
                        }
                        else {
                                System.out.println("Igel "+(icount)); }
                        a = (a % 0x1000000L) / 0x100; // % removes everything but last 6 digits, / removes last 6 digits
                        icount += 1;
                }
        }
}