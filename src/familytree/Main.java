package familytree;

import familytree.model.Gender;
import familytree.model.Human;
import familytree.utils.HumanComparator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human vasiliy = new Human(0, "Василий", Gender.MALE, LocalDate.of(1964, 5, 10));
        Human mariya = new Human(1, "Мария", Gender.FEMALE, LocalDate.of(1966, 3, 15));
        Human kristina = new Human(2, "Кристина", Gender.FEMALE, LocalDate.of(1988, 7, 20));
        Human semen = new Human(3, "Семен", Gender.MALE, LocalDate.of(1991, 1, 5));
        Human larisa = new Human(4, "Лариса", Gender.FEMALE, LocalDate.of(1946, 9, 1));

        vasiliy.setSpouse(mariya);
        mariya.setSpouse(vasiliy);
        vasiliy.setMother(larisa);
        kristina.setMother(mariya);
        kristina.setFather(vasiliy);
        semen.setMother(mariya);
        semen.setFather(vasiliy);

        vasiliy.addChild(kristina);
        vasiliy.addChild(semen);
        mariya.addChild(kristina);
        mariya.addChild(semen);
        larisa.addChild(vasiliy);

        familyTree.addHuman(vasiliy);
        familyTree.addHuman(mariya);
        familyTree.addHuman(kristina);
        familyTree.addHuman(semen);
        familyTree.addHuman(larisa);

        System.out.println("В дереве " + familyTree.size() + " объектов:");
        for (Human human : familyTree) {
            System.out.println(human);
        }

        System.out.println("\nСортировка по имени:");
        familyTree.sort(HumanComparator.SortCriteria.BY_NAME);
        for (Human human : familyTree) {
            System.out.println(human.getName());
        }

        System.out.println("\nСортировка по дате рождения:");
        familyTree.sort(HumanComparator.SortCriteria.BY_BIRTH_DATE);
        for (Human human : familyTree) {
            System.out.println(human.getName() + " - " + human.getBirthDate());
        }

        System.out.println("\nСортировка по ID:");
        familyTree.sort(HumanComparator.SortCriteria.BY_ID);
        for (Human human : familyTree) {
            System.out.println(human.getId() + " - " + human.getName());
        }
    }
}