package adventofcode.Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("src/adventofcode/Day7/input.txt"));

        DirectoryEntry rootDirectory = new DirectoryEntry(null, "/");
        DirectoryEntry currentDirectory = rootDirectory;

        List<DirectoryEntry> allDirectories = new ArrayList<>();
        while (f.hasNext()) {
            String line = f.nextLine();
            String[] linearr = line.split(" ");
            if ("$".equals(linearr[0])) {
                if ("cd".equals(linearr[1])) {
                    if ("/".equals(linearr[2])) {
                        currentDirectory = rootDirectory;
                    } else if ("..".equals(linearr[2])) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        currentDirectory = currentDirectory.getDir(linearr[2]);
                    }
                }
            } else if ("dir".equals(linearr[0])) {
                DirectoryEntry de = new DirectoryEntry(currentDirectory, linearr[1]);
                currentDirectory.addFile(de);
                allDirectories.add(de);
            } else {
                currentDirectory.addFile(new FileEntry(linearr[1], Long.parseLong(linearr[0])));
            }
        }
//        long count = 0;
//        for (DirectoryEntry de : allDirectories) {
//            long size = de.size();
//            if (size < 100000) {
//                count+=size;
//            }
//        }
//        System.out.println(count);
        long sizeOfRoot = rootDirectory.size();
        long spaceLeft = 70000000 - sizeOfRoot;
        long spaceToRemove = 30000000 - spaceLeft;

        List<DirectoryEntry> candidates = new ArrayList<>();

        long count = 0;
        for (DirectoryEntry de: allDirectories) {
            if (de.size()  > spaceToRemove)
                candidates.add(de);
        }

        candidates.add(rootDirectory);
        candidates.sort((a,b) -> (int) (a.size() - b.size()));
        System.out.println(candidates.get(0).size());
    }
}
