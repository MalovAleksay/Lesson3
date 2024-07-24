package familytree.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Human spouse;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public Gender getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public Human getSpouse() { return spouse; }
    public void setSpouse(Human spouse) { this.spouse = spouse; }
    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public List<Human> getChildren() { return children; }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String toString() {
        return String.format("id: %d, имя: %s, пол: %s, дата рождения: %s, супруг(а): %s, мать: %s, отец: %s, дети: %s",
                id, name, gender, birthDate,
                spouse != null ? spouse.name : "нет",
                mother != null ? mother.name : "неизвестна",
                father != null ? father.name : "неизвестен",
                children.isEmpty() ? "отсутствуют" : String.join(", ", children.stream().map(c -> c.name).toArray(String[]::new)));
    }
}