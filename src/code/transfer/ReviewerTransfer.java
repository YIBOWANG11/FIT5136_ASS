package code.transfer;

import code.entity.Reviewer;

public class ReviewerTransfer implements Transferable<Reviewer>{
    @Override
    public ReviewerTransfer getTransfer() {
        return new ReviewerTransfer();
    }

    @Override
    public Reviewer toObjectBy(String[] info) {
        return new Reviewer(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]),
                info[3],info[4], TimeUtils.convertToDate(info[5]), info[6], info[7],info[8]);
    }

    @Override
    public String toStringBy(Reviewer reviewer) {
        return reviewer.toCsvLine();
    }
}
