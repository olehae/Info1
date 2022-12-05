public class MyOwnCurve {
        public static void main(String[] args) {
                int ln = StdIn.readInt();
                String input = StdIn.readString();
                StdOut.println(ln);
                StdOut.println(input);
                char[] inputarr = new char [ln];

                for (int i = 0; i < ln; i++) {
                        inputarr[i] = input.charAt(i); } // nimmt den String input und konveriert ihn zu einem char array
                double currentx = 0.0;
                double currenty = 0.0;
                double futurex = 1.0; // Da die erste Blickrichtung nach rechts ist
                double futurey = 0.0;

                StdDraw.setCanvasSize(1024, 1024);
                StdDraw.setScale(-10.0,10.0); // um das Ganze besser sehen zu können

                for (int i = 0; i < ln; i++) { // es wird über die Länge des Inputs iteriert
                        if (inputarr[i] == 'F') { // Es wird ein Strich in die aktuelle Richtung gezeichnet
                                StdDraw.line(currentx, currenty, futurex, futurey);
                                double tempx = currentx;
                                double tempy = currenty;
                                currentx = futurex;
                                currenty = futurey;
                                futurex = futurex-tempx+futurex; // Gleiche Richtung wie zuvor
                                futurey = futurey-tempy+futurey; // Gleiche Richtung wie zuvor
                        }
                        else if (inputarr[i] == 'L') { // Left turn ohne zeichnen
                                if (currentx < futurex && currenty == futurey) { // facing right
                                        futurex = currentx;
                                        futurey = futurey + 1.0; }
                                else if (currentx == futurex && currenty < futurey) { // facing up
                                        futurex = futurex - 1.0;
                                        futurey = currenty; }
                                else if (currentx > futurex && currenty == futurey) { // facing left
                                        futurex = currentx;
                                        futurey = futurey - 1.0; }
                                else if (currentx == futurex && currenty > futurey) { // facing down
                                        futurex = futurex + 1.0;
                                        futurey = currenty; }
                        }
                        else if (inputarr[i] == 'R') { // Right turn ohne zeichnen
                                if (currentx < futurex && currenty == futurey) { // facing right
                                        futurex = currentx;
                                        futurey = futurey - 1.0; }
                                else if (currentx == futurex && currenty < futurey) { // facing up
                                        futurex = currentx;
                                        futurey = futurey - 1.0; }
                                else if (currentx > futurex && currenty == futurey) { // facing left
                                        futurex = futurex + 1.0;
                                        futurey = futurey + 1.0; }
                                else if (currentx == futurex && currenty > futurey) { // facing down
                                        futurex = futurex - 1.0;
                                        futurey = futurey + 1.0; }
                        }
                }
        }
}