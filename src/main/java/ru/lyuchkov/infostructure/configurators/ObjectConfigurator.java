package ru.lyuchkov.infostructure.configurators;

import ru.lyuchkov.infostructure.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
