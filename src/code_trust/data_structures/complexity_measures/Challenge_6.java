package code_trust.data_structures.complexity_measures;

public class Challenge_6 {
    public static void main(String[] args) {
        int n = 10; //O(1)
        int sum = 0; //O(1)
        double pie = 3.14; //O(1)

        for (int var = 0; var < n; var++) {    //O(n)
            int j = 1;  //O(n)
            System.out.println("Pie: " + pie); //O(n)
            while(j < var) { // O((n) * (log2 var))
                sum += 1; // O((n) * (log2 var))
                j *= 2;  // O((n) * (log2 var))
            }
        } //end of for loop
        System.out.println("Sum: " + sum); //O(1)
    } //end of main
}
