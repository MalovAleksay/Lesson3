package familytree.presenter;

import familytree.model.FamilyMember;
import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;
import familytree.utils.FamilyMemberComparator;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
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
                    service.saveData();
                    view.displayMessage("Данные успешно сохранены.");
                    break;
                case 6:
                    service.loadData();
                    view.displayMessage("Данные успешно загружены.");
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
        FamilyMember newMember = view.getNewFamilyMemberInfo();
        service.addMember(newMember);
        view.displayMessage("Член семьи успешно добавлен в семейное древо.");
    }

    private void displayFamilyTree() {
        List<FamilyMember> members = service.getAllMembers();
        view.displayFamilyTree(members);
    }

    private void showMemberRelations() {
        int memberId = view.getMemberIdForRelations();
        FamilyMember member = service.getMember(memberId);
        if (member != null) {
            FamilyMember spouse = service.getMember(member.getSpouseId());
            FamilyMember mother = service.getMember(member.getMotherId());
            FamilyMember father = service.getMember(member.getFatherId());
            List<FamilyMember> children = member.getChildrenIds().stream()
                    .map(service::getMember)
                    .toList();
            view.displayRelations(member, spouse, mother, father, children);
        } else {
            view.displayMessage("Член семьи с указанным ID не найден.");
        }
    }

    private void sortFamilyTree() {
        FamilyMemberComparator.SortCriteria criteria = view.getSortCriteria();
        service.sortMembers(criteria);
        view.displayMessage("Семейное древо отсортировано.");
        displayFamilyTree();
    }
}