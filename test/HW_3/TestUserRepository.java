package HW_3;

import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUserRepository {
    @Test
    public void testLogoutUser() {
        User first = new User("Ivan", "admin123", true);
        first.authenticate("Ivan", "admin123");
        User second = new User("Andrey", "anddna", false);
        second.authenticate("Andrey", "anddna");
        User third = new User("Oleg", "superpass", false);
        third.authenticate("Oleg", "superpass");

        UserRepository userRepository = new UserRepository();

        userRepository.addUser(first);
        userRepository.addUser(second);
        userRepository.addUser(third);

        userRepository.logoutUser();

        assertThat(userRepository.getData().get(0)).isEqualTo(first);
    }
}
