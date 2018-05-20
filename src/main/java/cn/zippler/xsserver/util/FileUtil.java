package cn.zippler.xsserver.util;


import java.io.File;


public class FileUtil {
    public static String getVideoPath(){
        File file = new File("./video");
        if (!file.exists()){
            file.mkdir();
        }
        return file.getPath();
    }


    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

}
