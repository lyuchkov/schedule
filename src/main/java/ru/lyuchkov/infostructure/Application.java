package ru.lyuchkov.infostructure;

import ru.lyuchkov.infostructure.config.ConfigImpl;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        ConfigImpl config = new ConfigImpl(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        context.setFactory(objectFactory);
        return context;
    }
}
