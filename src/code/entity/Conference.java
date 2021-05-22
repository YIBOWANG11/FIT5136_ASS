package code.entity;

import code.transfer.EntityPrinter;
import code.transfer.TimeUtils;
import code.transfer.TransferToCsvLine;

import java.time.LocalDate;

public class Conference implements TransferToCsvLine, EntityPrinter {
    private Integer id;
    private String title;
    private LocalDate deadline;

    public Conference() {

    }

    public Conference(Integer id, String title, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
    }

    public String getDeadline() {
        return TimeUtils.convertToString(this.deadline);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(String deadline) {
        this.deadline = TimeUtils.convertToDate(deadline);
    }

    @Override
    public String getEntityLine() {
        return String.format("id : %d, title : %s, deadline : %s", id, title, TimeUtils.convertToString(deadline));
    }

    @Override
    public String toCsvLine() {
        return String.format("%d,%s,%s", id, title, TimeUtils.convertToString(deadline));
    }
}
