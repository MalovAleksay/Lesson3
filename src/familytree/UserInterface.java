package familytree;

import familytree.utils.FamilyMemberComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface<T extends FamilyMember<T>> {
    private FamilyTree<T> familyTree;
    private Scanner scanner;
    private FamilyMemberFactory<T> factory;

    public UserInterface(FamilyMemberFactory<T> factory) {
        this.familyTree = new FamilyTree<>();
        this.scanner = new Scanner(System.in);
        this.factory = factory;
    }

    // Добавляем геттер для familyTree
    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFamilyMember();
                    break;
                case 2:
                    displayFamilyTree();
                    break;
                case 3:
                    sortFamilyTree();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1. Добавить члена семьи");
        System.out.println("2. Показать семейное древо");
        System.out.println("3. Отсортировать семейное древо");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    private void addFamilyMember() {
        System.out.print("Введите ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (M/F): ");
        String gender = scanner.nextLine().toUpperCase();

        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        T member = factory.create(id, name, gender, birthDate);
        familyTree.addMember(member);
        System.out.println("Член семьи успешно добавлен в семейное древо.");
    }

    private void displayFamilyTree() {
        System.out.println("\nСемейное древо:");
        for (T member : familyTree) {
            System.out.println(member);
        }
    }

    private void sortFamilyTree() {
        System.out.println("Выберите критерий сортировки:");
        System.out.println("1. По имени");
        System.out.println("2. По дате рождения");
        System.out.println("3. По ID");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        FamilyMemberComparator.SortCriteria criteria;
        switch (choice) {
            case 1:
                criteria = FamilyMemberComparator.SortCriteria.BY_NAME;
                break;
            case 2:
                criteria = FamilyMemberComparator.SortCriteria.BY_BIRTH_DATE;
                break;
            case 3:
                criteria = FamilyMemberComparator.SortCriteria.BY_ID;
                break;
            default:
                System.out.println("Неверный выбор. Сортировка не выполнена.");
                return;
        }

        familyTree.sort(criteria);
        System.out.println("Семейное древо отсортировано.");
    }
}