public class kurven {

  public static void random(int k) {
    if (k < 0 || k > 100000) {
      System.out.println("Invalid Input, number for R must be >0 and <=100000");
    }
    else {
      System.out.println("k: " + k);
      String[] character = new String[] {"F", "L", "R"}; // the three chars given by the task
      String output = "";
      for (int i = 1; i <= k; i++) {
        int number = StdRandom.uniformInt(3); // create a random int between 0 and 2
        output = output + character[number]; // add one char to the output
      }
      System.out.println("Random: " + output);
    }
  }

  public static void drachenkurve(int k) {
    if (k < 0 || k > 20) {
      System.out.println("Invalid Input, number for D must be >=0 and <=20");
    }
    else {
      System.out.println("k: " + k);
      String output = "F"; // Ordnung 0: F
      for (int i = 1; i <= k; i++) { // Do everything k times
        String new_string = "";
        // iterate over previous String in reverse
        for (int char_num = output.length() - 1; char_num >= 0; char_num--) {
          // get every single char from String (in reverse)
          char current = output.charAt(char_num);
          // replace chars according to task
          if (current == 'F') {
            new_string += "F";
          }
          else if (current == 'L') {
            new_string += "R";
          }
          else if (current == 'R') {
            new_string += "L";
          }
        }
        // ceate new String according to task
        output = output + "R" + new_string;
      }
      System.out.println("Drachen: " + output);
      System.out.println("Länge: " + output.length());
    }
  }

  public static void levy(int k) {
    if (k < 0 || k > 20) {
      System.out.println("Invalid Input, number for L must be >=0 and <=20");
    }
    else {
      System.out.println("k: " + k);
      String output = "F";
      for (int i = 1; i <= k; i++) { // Do everything k times
        String new_string = "";
        // new String according to task
        output = "+" + output + "--" + output + "+";
      }
      System.out.println("Levy (+-): " + output);
      System.out.println("Levy (FLR): " + plusminus_to_str(output, k));
      System.out.println("Länge: " + plusminus_to_str(output, k).length());
    }
  }

  public static String plusminus_to_str(String plusminus, int Ordnung) {
    String flr = "";
    int rotation = 0;
    // ignore the first + and the last -
    for (int i = Ordnung; i < plusminus.length() - Ordnung; i++) {
      if (plusminus.charAt(i) == 'F') {
        // rotation can only be 0, 2 or -2
        if (rotation == 0) {
          flr += "F";
        }
        if (rotation == 2) {
          flr += "RF";
        }
        if (rotation == -2) {
          flr += "LF";
        }
        rotation = 0; // reset rotation after every F
      }
      else if (plusminus.charAt(i) == '+') {
        rotation += 1;
      }
      else if (plusminus.charAt(i) == '-') {
        rotation -= 1;
      } 
    }
    return flr;
  }

  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    String curve = args[1];
    if (curve.equals("R")) {
      random(k);
    }
    else if (curve.equals("D")) {
      drachenkurve(k);
    }
    else if (curve.equals("L")) {
      levy(k);
    }
    else {
      System.out.println("You can only use R (random), D (drachenkurve) and L (levy");
    }
  }
}