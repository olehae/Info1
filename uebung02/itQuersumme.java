public class itQuersumme {

        public static void main( String[] args ){
                int x = Integer.parseInt(args[0]); // Zahl der Kommandozeile
                int itqsum = 0;

                while (x >= 10) {
                        while (x > 0) {
                                itqsum += x%10;
                                x = x / 10;
                        }
                        x = itqsum;
                        System.out.println(x);
                        itqsum = 0;
                }
        }
}