package code.transfer;

import code.entity.Conference;

public class ConferenceTransfer implements Transferable<Conference> {
    @Override
    public Transferable getTransfer() {
        return new ConferenceTransfer();
    }

    @Override
    public Conference toObjectBy(String[] info) {
        return new Conference(Integer.parseInt(info[0]), info[1], TimeUtils.convertToDate(info[2]));
    }

    @Override
    public String toStringBy(Conference conference) {
        return conference.toCsvLine();
    }
}
