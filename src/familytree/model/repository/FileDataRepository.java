package familytree.model.repository;

import familytree.model.FamilyTree;
import java.io.*;

public class FileDataRepository implements FamilyTreeRepository {
    private static final String FILE_PATH = "family_tree.ser";

    @Override
    public void saveTree(FamilyTree tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree loadTree() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new FamilyTree();
        }
    }
}