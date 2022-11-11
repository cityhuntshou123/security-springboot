import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/11 11:30
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt() {
        // 对密码加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.err.println("hashpw----------------------" + hashpw);
        System.out.println("$2a$10$2SPcpyoWwXqwtxr9nPyOsewMqwsyuzaj68u/TnFLxtnT2t8Rbc42i".equalsIgnoreCase(hashpw));

        // 校验密码
        System.err.println(BCrypt.checkpw("123", "$2a$10$2SPcpyoWwXqwtxr9nPyOsewMqwsyuzaj68u/TnFLxtnT2t8Rbc42i"));
        System.err.println(BCrypt.checkpw("123", "$2a$10$6i27DydnMN9ch/VTqxaIFujZe4xDNeq.nGk0X.0PtDOffJ137IheK"));

    }
}
