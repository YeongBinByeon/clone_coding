package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringBootAnnotation;

@MySpringBootAnnotation
public class MySpringBootMain {
    public static void main(String[] args){
        System.out.println("MySpringBootMain.main");
        MySpringApplication.run(MySpringBootMain.class, args);
    }
}
