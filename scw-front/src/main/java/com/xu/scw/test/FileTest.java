package com.xu.scw.test;


import java.io.File;

/**
 * @authorxuhongda on 2017/12/4
 * com.xu.scw.test
 * scw-parent
 */
public class FileTest {
    public static void main(String[] args) {
        String path ="E:/img";
        File file = new File(path);
        boolean mkdir = file.mkdir();
        if (mkdir){
            System.out.println("suc");
        }
    }
}
