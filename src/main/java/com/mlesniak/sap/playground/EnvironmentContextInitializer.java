package com.mlesniak.sap.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Detects the current landscape the application is run on and initializes the Spring
 * {@link ApplicationContext} accordingly.
 *
 * @see ApplicationContextInitializer
 */
public class EnvironmentContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger logger = LoggerFactory.getLogger(EnvironmentContextInitializer.class);

    public enum RuntimeEnvironment {
        DEV,
        PRODUCTION
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        RuntimeEnvironment stage = getEnvironment();
        applicationContext.getEnvironment().setActiveProfiles(stage.name().toLowerCase());
    }

    /**
     * Returns the {@link RuntimeEnvironment} the application runs in. Defaults to <code>CLOUD</code>.
     *
     * @return The {@link RuntimeEnvironment} the application runs in
     */
    public static RuntimeEnvironment getEnvironment() {
        RuntimeEnvironment retVal = RuntimeEnvironment.PRODUCTION;

        // HC_LANDSCAPE is set on HCP-based environments.
        final String landscape = System.getenv("HC_LANDSCAPE");
        if (landscape == null) {
            retVal = RuntimeEnvironment.DEV;
        }

        logger.info("Application running in '{}' environment", retVal.name().toLowerCase());
        return retVal;
    }
}