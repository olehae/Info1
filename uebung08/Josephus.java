class Josephus {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Josephus <Länge> <Schrittweite>");
        }
        else {
            int length = Integer.parseInt(args[0]);
            int step = Integer.parseInt(args[1]);
            int[] circle = josephusPermutation(length, step); // init circle with josephusPermutation
            for (int i=0; i<circle.length-1; i++) {
                System.out.print(circle[i]+", ");
            }
            System.out.println(circle[circle.length-1]);
            josephusRecursive(circle, circle.length-1, step); // last at beginning is circle.length-1 -> first step goes to element 1
        }
    }

    public static int[] josephusPermutation(int length, int step) {
        int[] arr = new int[length];
        for (int i=0; i<length; i++) {
            arr[i] = 0; // every element is 0 -> their value will be changed later
        }
        return arr;
    }

    public static void josephusRecursive(int[] circle, int last, int step) {
        int position = last;
        int step_counter = 0;
        while (step_counter<step) {
            position = (position+1) % circle.length;
            if (circle[position] == 0) {  // only count as step if the element hasnt been eliminated yet
                step_counter++;
            }
        }
        circle[position] = circle[last] + 1; // count of round = count of last round + 1
        last = position; // current position will be the last position for the next round
        if (circle[position] == circle.length) { // if this is the case, length numbers have been eliminated
            for (int i=0;i<circle.length-1;i++) {
                System.out.print(circle[i]+", ");
            }
            System.out.println(circle[circle.length-1]);
        }
        else {
            josephusRecursive(circle, last, step); // recursion with new circle, new last and same step
        }
    }
}