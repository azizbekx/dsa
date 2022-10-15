package code_trust.algorithms.divide_and_conquer;

public class PascalTriangle {
    public static int[] pascalTriangleRecursive(int lineNumber) {
        int currentLineSize = lineNumber;
        int previousLineSize = currentLineSize - 1;
        int[] currentLine = new int[currentLineSize];

        if (lineNumber == 1) {
            currentLine[0] = 1;
            System.out.println(1);
            return currentLine;
        }else {
            int[] previousLine = pascalTriangleRecursive(lineNumber - 1);

            // Let's go through all elements of current line expect the first and last one
            // since they were and will be filled with 1's) and calculate current coefficient based on previous line
            for(int numIndex = 0; numIndex < currentLineSize; numIndex++){
                int leftCoefficient = (numIndex - 1) >= 0 ? previousLine[numIndex - 1] : 0;
                int rightCoefficient = numIndex < previousLineSize ? previousLine[numIndex] : 0;
                currentLine[numIndex] = leftCoefficient + rightCoefficient;
                System.out.print(leftCoefficient +rightCoefficient + " ");
            }
            System.out.println();
            return currentLine;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangleRecursive(n);
    }
}
