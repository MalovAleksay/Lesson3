package familytree.command;

import familytree.presenter.FamilyTreePresenter;

public class AddFamilyMemberCommand implements Command {
    private FamilyTreePresenter presenter;

    public AddFamilyMemberCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.addFamilyMember();
    }
}