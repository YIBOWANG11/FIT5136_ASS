package code.GUI.entity;


import code.entity.*;
import code.repo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Chair extends User {


    private PaperRepository paperRepository = PaperRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();
    private ConferenceRepository conferenceRepository = ConferenceRepository.getInstance();
    private EvaluationRepository evaluationRepository = EvaluationRepository.getInstance();
    private ReviewerRepository reviewerRepository = ReviewerRepository.getInstance();


    public void creatConference(Conference conference){
        Integer id = conferenceRepository.generateMaxId()+1;
        conference.setId(id);
        conferenceRepository.addOne(conference);
    }
    public void modifyConference(Conference conference){
        Conference conferenceOld = conferenceRepository.findById(conference.getId());
        conferenceOld.setTitle(conference.getTitle());
        conferenceOld.setDeadline(conference.getDeadline());
        conferenceRepository.saveAll();
    }

    public void assignPaper(Integer paperId, List<Integer> reviews){

        for (Integer reviewId : reviews) {
            Integer id = evaluationRepository.generateMaxId()+1;
            Evaluation evaluation = new Evaluation(id, paperId, reviewId, " ");
            evaluationRepository.addOne(evaluation);
        }
    }


    /**
     * paper completed reviews notice
     */
    public List<Evaluation> notification(){
        List<Paper> papers = paperRepository.findAll();
        List<Evaluation> resultEvaluations = new ArrayList<>();
        AtomicBoolean isCompleted = new AtomicBoolean(true);
        for (Paper paper:papers){
            if (paper.getState().equals("pending")){
                List<Evaluation> evaluations = evaluationRepository.findAllByPaperId(paper.getId());
                evaluations.forEach(op->{
                    if (op.getEvaluation().equals(" ")) {
                        isCompleted.set(false);
                    }});

                if (isCompleted.get()==true)
                    resultEvaluations.addAll(evaluations);
            }
        }

        return  resultEvaluations;
    }


    public void makeDecision(Integer paperId,String decision){
        Paper oldPaper = paperRepository.findById(paperId);
        oldPaper.setState("done");
        oldPaper.setResult(decision);
        paperRepository.saveAll();;
    }


    public List<Conference> listConference(){
        List<Conference> all = conferenceRepository.findAll();
        return all;
    }

    public List<Paper> listPaper(){
        List<Paper> all = paperRepository.findAll();
        return all;
    }

    public List<Reviewer> listReviewer(){
        List<Reviewer> all = reviewerRepository.findAll();
        return all;
    }

}

