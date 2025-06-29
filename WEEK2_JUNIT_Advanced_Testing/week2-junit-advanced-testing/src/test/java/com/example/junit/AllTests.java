// AllTests.java
package com.example.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ Test1.class, Test2.class })
public class AllTests {

}
