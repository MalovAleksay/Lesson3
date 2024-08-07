package familytree.utils;

import familytree.model.Gender;
import familytree.model.Human;
import familytree.service.FamilyTreeService;
import java.time.LocalDate;
import java.util.*;

public class FamilyTreeInitializer {

    public static void initializeDefaultFamilyTree(FamilyTreeService service) {
        List<Map<String, Object>> defaultFamilyMembers = Arrays.asList(
                createMemberInfo(1, "Иван", Gender.MALE, LocalDate.of(1940, 5, 15)),
                createMemberInfo(2, "Мария", Gender.FEMALE, LocalDate.of(1942, 8, 20)),
                createMemberInfo(3, "Петр", Gender.MALE, LocalDate.of(1965, 3, 10)),
                createMemberInfo(4, "Анна", Gender.FEMALE, LocalDate.of(1967, 11, 25)),
                createMemberInfo(5, "Алексей", Gender.MALE, LocalDate.of(1970, 7, 5)),
                createMemberInfo(6, "Елена", Gender.FEMALE, LocalDate.of(1972, 9, 30)),
                createMemberInfo(7, "Михаил", Gender.MALE, LocalDate.of(1990, 2, 14)),
                createMemberInfo(8, "Ольга", Gender.FEMALE, LocalDate.of(1992, 6, 18)),
                createMemberInfo(9, "Дмитрий", Gender.MALE, LocalDate.of(1995, 4, 22)),
                createMemberInfo(10, "Екатерина", Gender.FEMALE, LocalDate.of(1997, 12, 7))
        );

        for (Map<String, Object> memberInfo : defaultFamilyMembers) {
            service.addMember(memberInfo);
        }

        // Установка отношений
        setRelations(service, 1, 2, Arrays.asList(3, 5));
        setRelations(service, 2, 1, Arrays.asList(3, 5));
        setRelations(service, 3, 4, Arrays.asList(7, 8));
        setRelations(service, 4, 3, Arrays.asList(7, 8));
        setRelations(service, 5, 6, Arrays.asList(9, 10));
        setRelations(service, 6, 5, Arrays.asList(9, 10));

        setParents(service, 3, 1, 2);
        setParents(service, 5, 1, 2);
        setParents(service, 7, 3, 4);
        setParents(service, 8, 3, 4);
        setParents(service, 9, 5, 6);
        setParents(service, 10, 5, 6);
    }

    private static Map<String, Object> createMemberInfo(int id, String name, Gender gender, LocalDate birthDate) {
        Map<String, Object> memberInfo = new HashMap<>();
        memberInfo.put("id", id);
        memberInfo.put("name", name);
        memberInfo.put("gender", gender);
        memberInfo.put("birthDate", birthDate);
        return memberInfo;
    }

    private static void setRelations(FamilyTreeService service, int memberId, int spouseId, List<Integer> childrenIds) {
        service.setSpouse(memberId, spouseId);
        for (int childId : childrenIds) {
            service.addChild(memberId, childId);
        }
    }

    private static void setParents(FamilyTreeService service, int childId, int fatherId, int motherId) {
        service.setFather(childId, fatherId);
        service.setMother(childId, motherId);
    }
}