public class Quersumme {

        public static void main( String[] args ){
                int x = Integer.parseInt(args[0]); // Zahl der Kommandozeile

                int qsum = 0;

                while (x > 0) {
                        qsum += x%10;
                        x = x / 10;}
                System.out.println(qsum);
        }
}