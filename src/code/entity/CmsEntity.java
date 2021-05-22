package code.entity;

import code.transfer.*;

public enum CmsEntity {
    USER("user.csv", new UserTransfer(), "id,email,password,role"),
    PAPER("paper.csv", new PaperTransfer(), "id,authorId,conferenceId,topic,name,submitTime,format,state,result"),
    CONFERENCE("conference.csv", new ConferenceTransfer(), "id,title,deadline"),
    EVALUATION("evaluation.csv", new EvaluationTransfer(), "id,paperId,reviewerId,evaluation"),
    REVIEWER("reviewer.csv", new ReviewerTransfer(), "reviewerId,authorId,conferenceId,topic,name,submitTime,format,state,result");


    private String fileName;
    private Transferable transfer;
    private String fileTitle;

    CmsEntity(String fileName, Transferable transfer, String fileTitle) {
        this.fileName = fileName;
        this.transfer = transfer;
        this.fileTitle = fileTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public Transferable getTransfer() {
        return transfer;
    }

    public String getFileTitle() {
        return fileTitle;
    }
}
