package com.example.s3test.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class YamlPropertyLoadFactory implements PropertySourceFactory {
    /**
     * Create a {@link PropertySource} that wraps the given resource.
     *
     * @param name     the name of the property source
     *                 (can be {@code null} in which case the factory implementation
     *                 will have to generate a name based on the given resource)
     * @param resource the resource (potentially encoded) to wrap
     * @return the new {@link PropertySource} (never {@code null})
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        Properties properties = factoryBean.getObject();
        return new PropertiesPropertySource(
                Objects.requireNonNull(resource.getResource().getFilename()),
                Objects.requireNonNull(properties)
        );
    }
}
