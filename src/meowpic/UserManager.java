package meowpic;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users = new HashMap<>();

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        return true;
    }

    public User authenticateUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return new User(username);
        }
        return null;
    }
}
