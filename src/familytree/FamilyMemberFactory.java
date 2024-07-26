package familytree;

import java.time.LocalDate;

public interface FamilyMemberFactory<T extends FamilyMember<T>> {
    T create(int id, String name, String gender, LocalDate birthDate);
}