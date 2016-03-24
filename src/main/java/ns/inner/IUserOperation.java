package ns.inner;

import ns.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NS on 2016/3/23.
 */
@Repository(value = "userOperation")
public interface IUserOperation {
    public User selectUserById(int id);

    public User selectUserByName(@Param("username") String username);

    public Boolean isExists(@Param("username") String username, @Param("password") String password);

    public List<User> selectUsers(String username);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
