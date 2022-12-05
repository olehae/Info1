class ISBN10 {
        public static void main(String args[]){
                int isbn = 0;
                while(true) {
                        StdOut.println("Enter the ISBN:");
                        isbn = StdIn.readInt();
                        if (isbn > 999999999) {
                                StdOut.println("invalid number");
                                continue;
                        }
                        break;
                }
                int gew = 0;
                for (int i = 1; i<=9; i++) {
                        gew += (isbn%10)*(10-i); // add to sum of weighted digits
                        if (isbn > 10) {
                                StdOut.print((isbn%10)*(10-i)+" + "); }
                        else {
                                StdOut.print((isbn%10)*(10-i)); } // if and else only for printing
                        isbn = isbn/10; // shorten isbn to get second to last digit next
                }
                StdOut.println();
                StdOut.println("Sum: "+gew);
                int altqsum = 0;
                int i = 1;
                while (true) {
                        while (gew>0) {
                                if (i%2 == 1) {
                                        altqsum += gew%10;
                                        StdOut.print("+"+(gew%10)); }
                                else if (i%2 == 0) {
                                        altqsum -= gew%10;
                                        StdOut.print("-"+(gew%10)); }
                                gew = gew/10;
                                i += 1;
                        }
                if (altqsum<11) {
                        break; }
                else {
                        gew = altqsum;
                        altqsum = 0;
                        StdOut.print(" -> "); }
                }
                StdOut.println();
                while (altqsum<0) {
                        altqsum += 11; }
                StdOut.println("digit sum: "+altqsum);
        }
}