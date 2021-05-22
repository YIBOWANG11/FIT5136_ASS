package code.entity;

import code.repo.ConferenceRepository;
import code.repo.PaperRepository;
import code.repo.UserRepository;
import code.transfer.TimeUtils;
import code.userInterface.UserInterface;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lucks
 * @date 2021/5/15 16:05
 */
public class Chair extends User {


  public Chair(Integer id, String email, String password, String role) {
    super(id, email, password, role);
  }

  public Chair() {
  }

  private final PaperRepository paperRepository = PaperRepository.getInstance();
  private final UserRepository userRepository = UserRepository.getInstance();
  private final ConferenceRepository conferenceRepository = ConferenceRepository.getInstance();
  private final UserInterface ui = UserInterface.getInstance();

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
    List<Integer> availableOptions = Arrays.asList(1, 2);
    Scanner input = new Scanner(System.in);
    if (!availableOptions.contains(option)) {
      System.out.println("wrong option");
    }
    if (option == 1) {
      creatConference();
    }
    if (option == 2) {
      modifyConference();
    }

  }

  public void displayPage() {
    ui.chair();
  }

  public void sendNotification(Author author){
    System.out.println("send notification");
  }

  public void creatConference(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("conferenceId:");
    String conferenceId= scanner.nextLine();
    System.out.println("conferenceTitle:");
    String conferenceTitle = scanner.nextLine();
    System.out.println("conferenceDeadline:");
    String conferenceDeadline = scanner.nextLine();

    Conference conference = new Conference(
        Integer.parseInt(conferenceId),
        conferenceTitle,
        TimeUtils.convertToDate(conferenceDeadline));

    conferenceRepository.addOne(conference);
  }
  public void modifyConference(){
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    do{
      listConference();
      System.out.println("which conference want to modify(0 for exit):");
      String conferenceId = scanner.nextLine();
      if(conferenceId.equals("0")) break;

      Conference conference = conferenceRepository.findById(Integer.parseInt(conferenceId));
      if (null ==conference){
        System.out.println("conference not exist.");
        return;
      }
      System.out.println("set new title:");
      String title = scanner.nextLine();
      System.out.println("set new deadline:");
      String deadLine = scanner.nextLine();

      conference.setTitle(title);
      conference.setDeadline(deadLine);
      conferenceRepository.saveAll();
    } while(true);
  }


  public void listConference(){
    System.out.println("-------------------conferences--------------------");
    List<Conference> conferences = conferenceRepository.findAll();
    //list
    conferences.stream().forEach(op-> System.out.println(op.getEntityLine()));
    System.out.println("---------------------------------------------------");
  }
}
