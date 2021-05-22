package code.repo;

import code.accessor.Accessor;
import code.entity.CmsEntity;
import code.entity.Reviewer;

import java.util.Comparator;
import java.util.List;

public class ReviewerRepository implements Repository<Reviewer> {
    private static final Accessor<Reviewer> REVIEWER_ACCESSOR = new Accessor<>(CmsEntity.REVIEWER);
    private static List<Reviewer> reviewers = REVIEWER_ACCESSOR.loadAll();
    private static ReviewerRepository instance = null;

    private ReviewerRepository() {

    }

    public static ReviewerRepository getInstance() {
        if (null == instance) {
            instance = new ReviewerRepository();
        }
        return instance;
    }


    @Override
    public List<Reviewer> findAll() {
        reviewers = REVIEWER_ACCESSOR.loadAll();
        return reviewers;
    }


    @Override
    public void addOne(Reviewer reviewer) {
        reviewers.add(reviewer);
        REVIEWER_ACCESSOR.saveAll(reviewers);
        reviewers = REVIEWER_ACCESSOR.loadAll();
    }


    public void saveAll(){
        REVIEWER_ACCESSOR.saveAll(reviewers);
        reviewers = REVIEWER_ACCESSOR.loadAll();
    }
    @Override
    public Integer generateMaxId() {

        return reviewers.stream()
                .max(Comparator.comparingInt(Reviewer::getId))
                .get()
                .getId();
    }


    @Override
    public void retrieveAll() {
        reviewers.forEach(reviewer -> {
            System.out.println(reviewer.getEntityLine());
        });
    }


}
