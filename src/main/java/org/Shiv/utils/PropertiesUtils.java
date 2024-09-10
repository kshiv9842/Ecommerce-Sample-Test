package org.Shiv.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static org.Shiv.utils.FileUtil.readPropertyFile;

//
public class PropertiesUtils {

    //Read application.properties file

    private static final String APP_PROPERTY_File= Paths.get(System.getProperty("user.dir"),"src","main","resources","application.properties").toString();

    public static String getPropertyValue(String key) {
        return readPropertyFile(APP_PROPERTY_File).get(key)
                .toString();
    }
}
