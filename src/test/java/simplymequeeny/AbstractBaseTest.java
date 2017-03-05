package simplymequeeny;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import simplymequeeny.configs.WebAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public abstract class AbstractBaseTest {

}
