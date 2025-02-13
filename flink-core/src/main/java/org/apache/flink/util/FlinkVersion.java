package org.apache.flink.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Get Flink version. */
public final class FlinkVersion {
    private static final String VERSION = loadVersion();
    private static final String VERSION_FILE_PATH = "criteo-flink-version.properties";

    private FlinkVersion() {}

    public static String loadVersion() {
        Properties properties = new Properties();

        try (InputStream inputStream =
                FlinkVersion.class.getClassLoader().getResourceAsStream(VERSION_FILE_PATH)) {
            if (inputStream == null) {
                return null;
            }

            properties.load(inputStream);

            return properties.getProperty("flink.version");

        } catch (IOException e) {
            return null;
        }
    }

    public static String get() {
        return VERSION;
    }
}
