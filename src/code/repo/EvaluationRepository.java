package code.repo;

import code.accessor.Accessor;
import code.entity.CmsEntity;
import code.entity.Evaluation;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluationRepository implements Repository<Evaluation>{
    private static final Accessor<Evaluation> EVALUATION_ACCESSOR = new Accessor<>(CmsEntity.EVALUATION);
    private static List<Evaluation> evaluations = EVALUATION_ACCESSOR.loadAll();
    private static EvaluationRepository instance = null;

    public static EvaluationRepository getInstance() {
        if (null == instance) {
            instance = new EvaluationRepository();
        }
        return instance;
    }


    @Override
    public List<Evaluation> findAll() {
        evaluations = EVALUATION_ACCESSOR.loadAll();
        return evaluations;
    }

    @Override
    public void addOne(Evaluation evaluation) {
        evaluations.add(evaluation);
        EVALUATION_ACCESSOR.saveAll(evaluations);
        evaluations = EVALUATION_ACCESSOR.loadAll();
    }

    public void addAll(List<Evaluation> evaluationList){
        evaluations.addAll(evaluationList);
        EVALUATION_ACCESSOR.saveAll(evaluations);
        evaluations = EVALUATION_ACCESSOR.loadAll();
    }

    public List<Evaluation> findAllByPaperId(Integer paperId){
        return evaluations.stream()
            .filter(op->op.getPaperId().equals(paperId))
            .collect(Collectors.toList());
    }

    @Override
    public Integer generateMaxId() {
        return evaluations.stream()
                .max(Comparator.comparingInt(Evaluation::getId))
                .get()
                .getId();
    }

    @Override
    public void retrieveAll() {
        System.out.println("not support");
    }
}
