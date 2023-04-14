import spring.user.dao.ConnectionMaker;
import spring.user.dao.DConnectionMaker;
import spring.user.dao.DaoFactory;
import spring.user.dao.UserDao;
import spring.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        UserDao dao = new DaoFactory().userDao();
        //UserDaoTest는 이제 UserDao가 어떻게 만들어졌는지 어떻게 초기화되어 있는지에 신경쓰지 않고 팩토리로부터 UserDao오브젝트를 받아다가,
        //ConnectionMaker connectionMaker = new DConnectionMaker();
        //UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("kika");
        user.setName("soccer");
        user.setPassword("korean ball");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
