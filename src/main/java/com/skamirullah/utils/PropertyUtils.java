package com.skamirullah.utils;

import com.skamirullah.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static com.skamirullah.constants.FrameworkConstants.getConfigFilePath;

public final class PropertyUtils {

    private PropertyUtils() {

    }

    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();


    static {
        try {
            FileInputStream file = new FileInputStream(getConfigFilePath());
            properties.load(file);
//            for(Object key : properties.keySet()){
//                CONFIG_MAP.put(String.valueOf(key), String.valueOf(properties.get(key)));
//            }

            //using entrySet()
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

            //using lambda
            //properties.entrySet().forEach(entry -> CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Better Way
    public static String get(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
            throw new Exception("Property name" + key + " is not found. Please check config.properties file");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }



    //Old Way
//    public static String getValue(String key) throws Exception {
//        if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
//            throw new Exception("Property name" + key + " is not found. Please check config.properties file");
//        }
//        return properties.getProperty(key);
//    }
}
