import spring.user.dao.UserDao;
import spring.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        UserDao dao = new UserDao();
        User user = new User();
        user.setId("whiteship");
        user.setName("안건우");
        user.setPassword("1414");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());

        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
