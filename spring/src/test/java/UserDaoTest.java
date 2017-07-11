import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.Location;

/**
 * Created by gedmk on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void inset() {
        User user = new User();
        user.setUser_name("小明");
        user.setPassword("12334");
        user.setAddress("焦作");
        user.setAccount_id(2);
        userDao.Insert(user);
    }

    @Test
    public void findById() {
        User user = userDao.findById(1);
        System.out.println(user);
    }

}
