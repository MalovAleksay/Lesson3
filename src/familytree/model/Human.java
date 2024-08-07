
package familytree.model;

import java.time.LocalDate;

public class Human extends AbstractFamilyMember {
    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        super(id, name, gender, birthDate);
    }

    @Override
    public String toString() {
        return String.format("id: %d, имя: %s, пол: %s, дата рождения: %s", getId(), getName(), getGender(), getBirthDate());
    }
}