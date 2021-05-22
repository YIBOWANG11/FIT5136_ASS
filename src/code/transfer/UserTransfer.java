package code.transfer;

import code.entity.User;

public class UserTransfer implements Transferable<User>{

    @Override
    public UserTransfer getTransfer() {
        return new UserTransfer();
    }

    @Override
    public User toObjectBy(String[] info){
        return new User(Integer.parseInt(info[0]), info[1], info[2], info[3]);
    }

    @Override
    public String toStringBy(User user) {
        return user.toCsvLine();
    }
}
