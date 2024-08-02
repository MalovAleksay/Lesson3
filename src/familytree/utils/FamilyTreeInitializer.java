package familytree.utils;

import familytree.model.FamilyMember;
import familytree.model.Human;
import familytree.model.Gender;
import familytree.service.FamilyTreeService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FamilyTreeInitializer {

    public static void initializeDefaultFamilyTree(FamilyTreeService service) {
        List<FamilyMember> defaultFamilyMembers = Arrays.asList(
                new Human(1, "Иван", Gender.MALE, LocalDate.of(1940, 5, 15)),
                new Human(2, "Мария", Gender.FEMALE, LocalDate.of(1942, 8, 20)),
                new Human(3, "Петр", Gender.MALE, LocalDate.of(1965, 3, 10)),
                new Human(4, "Анна", Gender.FEMALE, LocalDate.of(1967, 11, 25)),
                new Human(5, "Алексей", Gender.MALE, LocalDate.of(1970, 7, 5)),
                new Human(6, "Елена", Gender.FEMALE, LocalDate.of(1972, 9, 30)),
                new Human(7, "Михаил", Gender.MALE, LocalDate.of(1990, 2, 14)),
                new Human(8, "Ольга", Gender.FEMALE, LocalDate.of(1992, 6, 18)),
                new Human(9, "Дмитрий", Gender.MALE, LocalDate.of(1995, 4, 22)),
                new Human(10, "Екатерина", Gender.FEMALE, LocalDate.of(1997, 12, 7))
        );

        for (FamilyMember member : defaultFamilyMembers) {
            service.addMember(member);
        }

        // Установка отношений
        service.getMember(1).setSpouseId(2);
        service.getMember(2).setSpouseId(1);
        service.getMember(3).setSpouseId(4);
        service.getMember(4).setSpouseId(3);
        service.getMember(5).setSpouseId(6);
        service.getMember(6).setSpouseId(5);

        service.getMember(3).setMotherId(2);
        service.getMember(3).setFatherId(1);
        service.getMember(5).setMotherId(2);
        service.getMember(5).setFatherId(1);

        service.getMember(7).setMotherId(4);
        service.getMember(7).setFatherId(3);
        service.getMember(8).setMotherId(4);
        service.getMember(8).setFatherId(3);
        service.getMember(9).setMotherId(6);
        service.getMember(9).setFatherId(5);
        service.getMember(10).setMotherId(6);
        service.getMember(10).setFatherId(5);

        service.getMember(1).addChildId(3);
        service.getMember(1).addChildId(5);
        service.getMember(2).addChildId(3);
        service.getMember(2).addChildId(5);
        service.getMember(3).addChildId(7);
        service.getMember(3).addChildId(8);
        service.getMember(4).addChildId(7);
        service.getMember(4).addChildId(8);
        service.getMember(5).addChildId(9);
        service.getMember(5).addChildId(10);
        service.getMember(6).addChildId(9);
        service.getMember(6).addChildId(10);
    }
}