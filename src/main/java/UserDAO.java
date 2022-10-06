import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private List<User> users = new ArrayList<>();

    private static UserDAO userDaoInstance = null;

    private UserDAO() {

    }

    public static UserDAO getInstance()
    {
        if (userDaoInstance == null)
        {
            userDaoInstance = new UserDAO();
            return userDaoInstance;
        }
        return userDaoInstance;
    }

    public boolean create(User user)
    {
        if (user != null)
        {
           return users.add(user);
        }
        return false;
    }

    public User read(final int id)
    {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean update(int id, User user)
    {
        int index = users.indexOf(read(id));
        if (users.set(index, user) != null) return true;
        return false;
    }

    public boolean delete(int id)
    {
      return users.remove(read(id));
    }

    public List<User> readAll()
    {
        return users;
    }
}
