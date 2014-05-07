package test.testgroup;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cn.fuego.misp.dao.impl.SystemFunctionSetImplTest;

@RunWith(Suite.class)  
@SuiteClasses({SystemFunctionSetImplTest.class}) 
public class AllDaoTest
{

}
