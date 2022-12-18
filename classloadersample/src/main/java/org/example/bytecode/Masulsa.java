package org.example.bytecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args){

//        // 바이트코드를 변경하는 뒷 작업 수행
//        try {
//            new ByteBuddy().redefine(Moja.class)
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("C:\\code_folder\\clone_coding\\classloadersample\\target\\classes\\"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println();
//        //System.out.println(new Moja().pullOut());

        Arrays.stream(Moja.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(f.getAnnotations()).forEach(a->{
                if(a instanceof myAnnotation) {
                    myAnnotation myAnnotation = (org.example.bytecode.myAnnotation) a;
                    System.out.println(myAnnotation.number());
                    System.out.println(myAnnotation.value());
                }
            });
        });
    }
}
