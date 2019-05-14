package com.reporting.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  
	TransactionControllerTest.class, 
	UserControllerTest.class 
	})
public class PspReportingAllTests {

}
