package code.entity;


import code.repo.ConferenceRepository;
import code.repo.PaperRepository;
import code.repo.UserRepository;
import code.userInterface.UserInterface;

import java.util.Arrays;
import java.util.List;

public class Admin extends User {

    public Admin(Integer id, String email, String password, String role) {
        super(id, email, password, role);
    }

    public Admin() {
    }

    private final PaperRepository paperRepository = PaperRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();
    private final ConferenceRepository conferenceRepository = ConferenceRepository.getInstance();
    private final UserInterface ui = UserInterface.getInstance();

    public String Im() {
        return "admin:" + getEmail();
    }

    public void retrievePaper() {
        paperRepository.retrieveAll();
    }

    public void retrieveUser() {
        userRepository.retrieveAll();
    }

    public void retrieveConference() {
        conferenceRepository.retrieveAll();
    }

    public void runFeatureBy(Integer option) {
        List<Integer> availableOptions = Arrays.asList(1, 2, 3);
        if (!availableOptions.contains(option)) {
            System.out.println("错误选项");
        }
        if (option == 1) {
            retrieveUser();
        }
        if (option == 2) {
            retrievePaper();
        }
        if (option == 3) {
            retrieveConference();
        }
    }

    public void displayPage() {
        ui.admin();
    }
}
