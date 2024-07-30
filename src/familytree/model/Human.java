package familytree.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private int spouseId;
    private int motherId;
    private int fatherId;
    private List<Integer> childrenIds;

    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.spouseId = -1;
        this.motherId = -1;
        this.fatherId = -1;
        this.childrenIds = new ArrayList<>();
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public Gender getGender() { return gender; }

    @Override
    public int getSpouseId() { return spouseId; }

    @Override
    public void setSpouseId(int spouseId) { this.spouseId = spouseId; }

    @Override
    public int getMotherId() { return motherId; }

    @Override
    public void setMotherId(int motherId) { this.motherId = motherId; }

    @Override
    public int getFatherId() { return fatherId; }

    @Override
    public void setFatherId(int fatherId) { this.fatherId = fatherId; }

    @Override
    public List<Integer> getChildrenIds() { return new ArrayList<>(childrenIds); }

    @Override
    public void addChildId(int childId) {
        if (!childrenIds.contains(childId)) {
            childrenIds.add(childId);
        }
    }

    @Override
    public String toString() {
        return String.format("id: %d, имя: %s, пол: %s, дата рождения: %s", id, name, gender, birthDate);
    }
}