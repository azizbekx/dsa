package adventofcode.Day7;

import java.util.HashMap;
import java.util.Map;

public class DirectoryEntry extends FileEntry{
    private final DirectoryEntry parent;
    private Map<String, FileEntry> files = new HashMap<>();

    public DirectoryEntry(DirectoryEntry parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    public void addFile(FileEntry file) {
        files.put(file.getName(), file);
    }
    public long size() {
        long count = 0;
        for (FileEntry file : files.values()) {
            count += file.size();
        }
        return count;
    }
    public DirectoryEntry getParent() {
        return parent;
    }

    public DirectoryEntry getDir(String s) {
        return (DirectoryEntry) files.get(s);
    }


}
