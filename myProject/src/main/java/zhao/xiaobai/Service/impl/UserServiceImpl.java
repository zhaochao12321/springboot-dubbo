package zhao.xiaobai.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhao.xiaobai.Dao.UserDAO;
import zhao.xiaobai.Pojo.User;
import zhao.xiaobai.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public List<User> getUserMessage(String id) {
      return   userDAO.findByUserId(id);
    }
}
