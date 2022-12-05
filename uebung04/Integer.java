public class Integer {
        public static void main(String args[]) {
                for (int i = 1; i<=1000; i++) {
                        if (i%6 == 0 && i%7 == 0 && i%4 != 0 && Quersumme(i) == 6) {
                                System.out.println("Lieblingszahl: "+i); }
                }

        }

        public static int Quersumme(int x) {
                int qsum = 0;
                while (x > 0) {
                        qsum += x%10;
                        x = x / 10; }
                return qsum;
        }
}