package familytree;

import familytree.model.Human;
import familytree.model.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyMemberFactory<Human> humanFactory = (id, name, gender, birthDate) ->
                new Human(id, name, gender.equals("M") ? Gender.MALE : Gender.FEMALE, birthDate);

        UserInterface<Human> ui = new UserInterface<>(humanFactory);


        initializeTreeWithPredefinedData(ui.getFamilyTree());

        ui.start();
    }

    private static void initializeTreeWithPredefinedData(FamilyTree<Human> familyTree) {

        Human grandfather = new Human(1, "Иван", Gender.MALE, LocalDate.of(1940, 5, 15));
        Human grandmother = new Human(2, "Мария", Gender.FEMALE, LocalDate.of(1942, 8, 20));
        Human father = new Human(3, "Петр", Gender.MALE, LocalDate.of(1965, 3, 10));
        Human mother = new Human(4, "Анна", Gender.FEMALE, LocalDate.of(1967, 11, 25));
        Human uncle = new Human(5, "Алексей", Gender.MALE, LocalDate.of(1970, 7, 5));
        Human aunt = new Human(6, "Елена", Gender.FEMALE, LocalDate.of(1972, 9, 30));
        Human son = new Human(7, "Михаил", Gender.MALE, LocalDate.of(1990, 2, 14));
        Human daughter = new Human(8, "Ольга", Gender.FEMALE, LocalDate.of(1992, 6, 18));
        Human cousin1 = new Human(9, "Дмитрий", Gender.MALE, LocalDate.of(1995, 4, 22));
        Human cousin2 = new Human(10, "Екатерина", Gender.FEMALE, LocalDate.of(1997, 12, 7));


        grandfather.setSpouse(grandmother);
        grandmother.setSpouse(grandfather);

        father.setFather(grandfather);
        father.setMother(grandmother);
        father.setSpouse(mother);
        grandfather.addChild(father);
        grandmother.addChild(father);

        mother.setSpouse(father);

        uncle.setFather(grandfather);
        uncle.setMother(grandmother);
        uncle.setSpouse(aunt);
        grandfather.addChild(uncle);
        grandmother.addChild(uncle);

        aunt.setSpouse(uncle);

        son.setFather(father);
        son.setMother(mother);
        father.addChild(son);
        mother.addChild(son);

        daughter.setFather(father);
        daughter.setMother(mother);
        father.addChild(daughter);
        mother.addChild(daughter);

        cousin1.setFather(uncle);
        cousin1.setMother(aunt);
        uncle.addChild(cousin1);
        aunt.addChild(cousin1);

        cousin2.setFather(uncle);
        cousin2.setMother(aunt);
        uncle.addChild(cousin2);
        aunt.addChild(cousin2);


        familyTree.addMember(grandfather);
        familyTree.addMember(grandmother);
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(uncle);
        familyTree.addMember(aunt);
        familyTree.addMember(son);
        familyTree.addMember(daughter);
        familyTree.addMember(cousin1);
        familyTree.addMember(cousin2);
    }
}