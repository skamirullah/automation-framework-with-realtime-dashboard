package com.skamirullah.constants;

public final class FrameworkConstants {

private FrameworkConstants(){

}

private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/config.properties";
private static final int EXPLICIT_WAIT = 10;

public static String getConfigFilePath() {
    return CONFIG_FILE_PATH;
}

public static int getExplicitWait(){
    return EXPLICIT_WAIT;
}


}


