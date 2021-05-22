package code.entity;

import java.util.ArrayList;
import java.util.List;

public class Author extends User{
    public Author(Integer id, String email, String password, String role) {
        super(id, email, password, role);
    }

    public Author() {
    }

    public void submitPaper(){
        System.out.println("submit Paper");
    }

    public List<Notification> checkNotifications(){
        return new ArrayList<>();
    }
}
