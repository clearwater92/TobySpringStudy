import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import spring.user.dao.ConnectionMaker;
import spring.user.dao.DConnectionMaker;
import spring.user.dao.DaoFactory;
import spring.user.dao.UserDao;
import spring.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //@Configuration이 붙은 자바코드를 설정정보로 사용하려면 AnnotationConfigApplicationContext를 사용해야 한다
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        //UserDao dao = new DaoFactory().userDao();
        UserDao dao = context.getBean("userDao", UserDao.class);
        //UserDaoTest는 이제 UserDao가 어떻게 만들어졌는지 어떻게 초기화되어 있는지에 신경쓰지 않고 팩토리로부터 UserDao오브젝트를 받아다가,
        //ConnectionMaker connectionMaker = new DConnectionMaker();
        //UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("Vietnam Coffee");
        user.setName("coconut");
        user.setPassword("taste good");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
