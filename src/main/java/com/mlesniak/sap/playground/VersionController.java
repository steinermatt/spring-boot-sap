package com.mlesniak.sap.playground;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Show version information provided by the git-properties plugin.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
@RequestMapping("/rest/")
public class VersionController {
    private static final Logger LOG = LoggerFactory.getLogger(VersionController.class);

    @RequestMapping("/version")
    public Map<String, String> version() throws IOException {
        return getVersionInformation();
    }

    private Map<String, String> getVersionInformation() throws IOException {
        LOG.info("Version request");
        Map<String, String> info = new HashMap<>();
        InputStream is = VersionController.class.getResourceAsStream("/git.properties");
        if (is == null) {
            return info;
        }
        Properties properties = new Properties();
        properties.load(is);

        for (String key : properties.stringPropertyNames()) {
            info.put(key, properties.getProperty(key));
        }
        return info;
    }
}
