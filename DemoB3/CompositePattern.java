import java.util.ArrayList;
import java.util.List;

// 1) Giao diện chung cho cả File và Folder
interface FileComponent {
    void showInfo();
}

// 2) Leaf: File đơn lẻ
class FileLeaf implements FileComponent {
    private String name;

    public FileLeaf(String name) {
        this.name = name;
    }

    @Override
    public void showInfo() {
        System.out.println("File: " + name);
    }
}

// 3) Composite: Folder chứa nhiều File hoặc Folder khác
class FolderComposite implements FileComponent {
    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public FolderComposite(String name) {
        this.name = name;
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo() {
        System.out.println("Folder: " + name);
        for (FileComponent c : children) {
            c.showInfo();  // gọi đệ quy
        }
    }
}

// 4) Demo
public class CompositePattern {
    public static void main(String[] args) {
        FileLeaf file1 = new FileLeaf("document.txt");
        FileLeaf file2 = new FileLeaf("image.png");
        FileLeaf file3 = new FileLeaf("music.mp3");

        FolderComposite folder1 = new FolderComposite("My Documents");
        folder1.add(file1);
        folder1.add(file2);

        FolderComposite folder2 = new FolderComposite("Media");
        folder2.add(file3);

        FolderComposite root = new FolderComposite("Root");
        root.add(folder1);
        root.add(folder2);

        root.showInfo();
    }
}
