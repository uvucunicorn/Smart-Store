package com.unicorn;

import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test(){
        String filename = "afda.sfas.jpg";
        String substring = filename.substring(filename.lastIndexOf("."),filename.lastIndexOf(".")-3);
//        String suffix = filename.substring(filename.lastIndexOf("."));

        System.out.println(substring);
    }
}
