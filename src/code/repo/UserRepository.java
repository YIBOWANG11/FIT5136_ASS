package code.repo;

import code.accessor.Accessor;
import code.entity.CmsEntity;
import code.entity.User;

import java.util.Comparator;
import java.util.List;

public class UserRepository implements Repository<User> {
    private static final Accessor<User> USER_ACCESSOR = new Accessor<>(CmsEntity.USER);
    private static List<User> users = USER_ACCESSOR.loadAll();
    private static UserRepository instance = null;

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (null == instance) {
            return new UserRepository();
        }
        return instance;
    }

    @Override
    public List<User> findAll() {
        users = USER_ACCESSOR.loadAll();
        return users;
    }


    public User findByUserEmail(String email){
        for (User user : users) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public void addOne(User user) {
        users.add(user);
        USER_ACCESSOR.saveAll(users);
        users = USER_ACCESSOR.loadAll();
    }

    @Override
    public Integer generateMaxId() {
        return users.stream()
                .max(Comparator.comparingInt(User::getId))
                .get()
                .getId() + 1;
    }

    @Override
    public void retrieveAll() {
        users.forEach(
                user -> System.out.println(user.getEntityLine())
        );
    }

}
