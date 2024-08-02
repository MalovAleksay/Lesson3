package familytree.model.repository;

import familytree.model.FamilyMember;
import familytree.model.Gender;
import familytree.model.Human;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Применение принципа Single Responsibility (SRP)
// Класс отвечает только за сохранение и загрузку данных из файла
public class FileDataRepository implements FamilyTreeRepository {
    private static final String FILE_PATH = "src/main/resources/family_data.csv";

    // Выделение метода форматирования данных для улучшения читаемости

    @Override
    public void saveMembers(List<FamilyMember> members) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (FamilyMember member : members) {
                writer.println(String.format("%d,%s,%s,%s,%d,%d,%d,%s",
                        member.getId(),
                        member.getName(),
                        member.getGender(),
                        member.getBirthDate(),
                        member.getSpouseId(),
                        member.getMotherId(),
                        member.getFatherId(),
                        String.join("-", member.getChildrenIds().stream().map(String::valueOf).toArray(String[]::new))
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FamilyMember> loadMembers() {
        List<FamilyMember> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Human human = new Human(
                        Integer.parseInt(data[0]),
                        data[1],
                        Gender.valueOf(data[2]),
                        LocalDate.parse(data[3])
                );
                human.setSpouseId(Integer.parseInt(data[4]));
                human.setMotherId(Integer.parseInt(data[5]));
                human.setFatherId(Integer.parseInt(data[6]));
                if (data.length > 7 && !data[7].isEmpty()) {
                    for (String childId : data[7].split("-")) {
                        human.addChildId(Integer.parseInt(childId));
                    }
                }
                members.add(human);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }
}