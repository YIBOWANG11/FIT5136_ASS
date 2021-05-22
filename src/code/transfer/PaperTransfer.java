package code.transfer;

import code.entity.Paper;

public class PaperTransfer implements Transferable<Paper>{
    @Override
    public PaperTransfer getTransfer() {
        return new PaperTransfer();
    }

    @Override
    public Paper toObjectBy(String[] info) {
        return new Paper(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]),
                info[3],info[4], TimeUtils.convertToDate(info[5]), info[6], info[7],info[8]);
    }

    @Override
    public String toStringBy(Paper paper) {
        return paper.toCsvLine();
    }
}
