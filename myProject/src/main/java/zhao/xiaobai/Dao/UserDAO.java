package zhao.xiaobai.Dao;

import org.springframework.data.repository.CrudRepository;
import zhao.xiaobai.Pojo.User;

import java.util.List;

public interface UserDAO extends CrudRepository<User, String> {

public List<User> findByUserId(String id);


}
