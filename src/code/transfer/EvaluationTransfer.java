package code.transfer;

import code.entity.Evaluation;

public class EvaluationTransfer implements Transferable {
    @Override
    public Transferable getTransfer() {
        return new EvaluationTransfer();
    }

    @Override
    public Evaluation toObjectBy(String[] info) {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(Integer.parseInt(info[0]));
        evaluation.setPaperId(Integer.parseInt(info[1]));
        evaluation.setReviewerId(Integer.parseInt(info[2]));
        evaluation.setEvaluation(info[3]);
        return evaluation;
    }

    @Override
    public String toStringBy(Object entity) {
        Evaluation temp =(Evaluation) entity;
        return String.format("%s,%s,%s,%s",temp.getId(),temp.getPaperId(),temp.getReviewerId(),temp.getEvaluation());
    }
}
