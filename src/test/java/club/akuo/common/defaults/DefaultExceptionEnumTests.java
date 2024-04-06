package club.akuo.common.defaults;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static club.akuo.common.defaults.DefaultServerExceptionEnum.NOT_ALLOW;

/**
 * @author akuowen
 */
public class DefaultExceptionEnumTests {

    @Test
    public void testDefaultException(){
        NOT_ALLOW.assertNotNull("1");
        NOT_ALLOW.assertNotNull("1","测试参数");
        NOT_ALLOW.assertNotEmpty("1");
        NOT_ALLOW.assertNotEmpty("1","测试参数");
        NOT_ALLOW.assertNotEmpty(new Object[]{new Object()});
        NOT_ALLOW.assertNotEmpty(new Object[]{new Object()},"测试参数");
        NOT_ALLOW.assertNotEmpty(Arrays.asList("1","2","3"));
        NOT_ALLOW.assertNotEmpty(Arrays.asList("1","2","3"),"测试参数");
//        NOT_ALLOW.assertNotEmpty(new HashMap<>());
        NOT_ALLOW.assertNotEmpty(new HashMap<>(),"这个集合是空的");
        NOT_ALLOW.assertIsFalse(false);
        NOT_ALLOW.assertIsFalse(false,"测试参数");
        NOT_ALLOW.assertIsTrue(true);
        NOT_ALLOW.assertIsTrue(true,"测试参数");
        NOT_ALLOW.assertIsNull(null);
        NOT_ALLOW.assertIsNull(null,"测试参数");
//        NOT_ALLOW.assertFail();
//        NOT_ALLOW.assertFail("测试参数");
//        NOT_ALLOW.assertFail(new IllegalAccessError("权限错误"));
//        NOT_ALLOW.assertFail(new IllegalAccessError("权限错误"),"测试参数");
        NOT_ALLOW.assertEquals("1","1");
        NOT_ALLOW.assertEquals("1","1","测试参数");
    }
}
