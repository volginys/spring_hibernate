package hiber.service;

import java.util.List;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
   @Autowired
   private UserDao userDao;
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Override
   public User findByCar(Car car) {
      return userDao.findByCar(car);
   }
}
