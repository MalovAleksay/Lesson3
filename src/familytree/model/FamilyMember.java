package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember extends Serializable {
    int getId();
    String getName();
    LocalDate getBirthDate();
    Gender getGender();
    int getSpouseId();
    void setSpouseId(int spouseId);
    int getMotherId();
    void setMotherId(int motherId);
    int getFatherId();
    void setFatherId(int fatherId);
    List<Integer> getChildrenIds();
    void addChildId(int childId);
}