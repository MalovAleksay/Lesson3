package familytree.command;

import familytree.presenter.FamilyTreePresenter;

public class SortFamilyTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortFamilyTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortFamilyTree();
    }
}