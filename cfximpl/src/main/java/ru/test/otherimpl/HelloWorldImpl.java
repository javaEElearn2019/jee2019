
package ru.test.otherimpl;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.test.otherimpl.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

