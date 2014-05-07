package test.testgroup;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cn.fuego.misp.web.action.login.LoginActionTest;


@RunWith(Suite.class)  
@SuiteClasses({LoginActionTest.class}) 

public class AllActionTest
{

}
