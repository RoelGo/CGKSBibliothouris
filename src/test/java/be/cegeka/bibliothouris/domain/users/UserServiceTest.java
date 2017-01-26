package be.cegeka.bibliothouris.domain.users;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(userService, "counter", new AtomicLong(4L));
    }

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("Seppe","Gielen","36546464654","Leuven","'t torentje","10","2500");

        verify(userRepository).addUser(new User(5L, "Seppe","Gielen","36546464654","Leuven","'t torentje","10","2500"));
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 = new User(1l, "Seppe","Gielen","36546464654","Leuven","'t torentje","10","2500");
        User user2 = new User(2l, "Sanne","Gielen","36546464654","Leuven","'t torentje","10","2500");
        User user3 = new User(3l, "Xan","Gielen","36546464654","Leuven","'t torentje","10","2500");

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2);
    }
}