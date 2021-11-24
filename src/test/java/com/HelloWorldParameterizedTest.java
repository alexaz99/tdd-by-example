package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HelloWorldParameterizedTest {

    @ParameterizedTest
    //@ValueSource(ints = {3, 4, 5, 8, 14})
    @ValueSource(strings = {"a","b","c"})
    void hello(String val) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setHello(val);
        Assertions.assertEquals(val, helloWorld.hello());
    }
}