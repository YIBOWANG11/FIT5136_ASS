package code.entity;

public class Evaluation {
    private Integer id;
    private Integer paperId;
    private Integer reviewerId;
    private String evaluation ;

    public Evaluation() {
    }

    public Evaluation(Integer id, Integer paperId, Integer reviewerId, String evaluation) {
        this.id = id;
        this.paperId = paperId;
        this.reviewerId = reviewerId;
        this.evaluation = evaluation;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
