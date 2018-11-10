import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanConfigTest {
    @Test
    public void beanConfigTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    }
}
