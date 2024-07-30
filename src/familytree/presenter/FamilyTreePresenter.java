package familytree.presenter;

import familytree.model.FamilyTree;
import familytree.model.Human;
import familytree.model.FileDataManager;
import familytree.view.FamilyTreeView;
import familytree.utils.FamilyMemberComparator;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyTreePresenter {
    private FamilyTree model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    addFamilyMember();
                    break;
                case 2:
                    displayFamilyTree();
                    break;
                case 3:
                    showMemberRelations();
                    break;
                case 4:
                    sortFamilyTree();
                    break;
                case 5:
                    saveData();
                    break;
                case 6:
                    loadData();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    view.displayMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }


    private void addFamilyMember() {
        Human newMember = view.getNewFamilyMemberInfo();
        model.addMember(newMember);
        view.displayMessage("Член семьи успешно добавлен в семейное древо.");
    }

    private void displayFamilyTree() {
        List<Human> members = model.getAllMembers();
        view.displayFamilyTree(members);
    }

    private void showMemberRelations() {
        int memberId = view.getMemberIdForRelations();
        Human member = model.getMember(memberId);
        if (member != null) {
            Human spouse = model.getMember(member.getSpouseId());
            Human mother = model.getMember(member.getMotherId());
            Human father = model.getMember(member.getFatherId());
            List<Human> children = member.getChildrenIds().stream()
                    .map(model::getMember)
                    .collect(Collectors.toList());
            view.displayRelations(member, spouse, mother, father, children);
        } else {
            view.displayMessage("Член семьи с указанным ID не найден.");
        }
    }

    private void saveData() {
        FileDataManager.saveToFile(model.getAllMembers());
        view.displayMessage("Данные успешно сохранены.");
    }

    private void loadData() {
        model.clear();
        FileDataManager.loadFromFile(model);
        view.displayMessage("Данные успешно загружены.");
    }
    private void sortFamilyTree() {
        FamilyMemberComparator.SortCriteria criteria = view.getSortCriteria();
        model.sort(criteria);
        view.displayMessage("Семейное древо отсортировано.");
        displayFamilyTree();
    }
}