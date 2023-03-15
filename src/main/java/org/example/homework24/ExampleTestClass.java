package org.example.homework24;

class ExampleTestClass {
    @BeforeSuite
    public void before() {
        System.out.println("Before suite method");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3");
    }

    @AfterSuite
    public void after() {
        System.out.println("After suite method");
    }
}
