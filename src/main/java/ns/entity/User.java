package ns.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by NS on 2016/3/21.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -8310037957348359545L;

    private int id;
    private String username;
    private String password;
    private Date datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", datetime=" + datetime +
                ", password='" + password + '\'' +
                '}';
    }
}
