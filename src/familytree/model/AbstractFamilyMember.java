package familytree.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFamilyMember implements FamilyMember {
    protected int id;
    protected String name;
    protected Gender gender;
    protected LocalDate birthDate;
    protected int spouseId;
    protected int motherId;
    protected int fatherId;
    protected List<Integer> childrenIds;

    public AbstractFamilyMember(int id, String name, Gender gender, LocalDate birthDate) {
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
}