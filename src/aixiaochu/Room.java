package aixiaochu;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/4/11.
 */
public class Room implements Serializable{
    private Integer ID;
    private String name;
    private User[] users;
    private String type;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
