package es.sisifo.plugin.codegenerator.service;

import java.lang.reflect.Method;

public class SetterGetterGeneratorServiceImpl implements SetterGetterGeneratorService {


    @Override
    public String generateSetters(final Class<?> clazz, final String objectSet, final String objectGet) {
        final StringBuilder codigoJava = new StringBuilder();

        for (final Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                codigoJava.append(objectSet).append(".").append(method.getName()).append("(").append(objectGet)
                        .append(".").append(convertSetEnGet(method.getName())).append("()").append(");\n");
            }
        }

        return codigoJava.toString();
    }


    private String convertSetEnGet(final String methodSetName) {
        return "get" + methodSetName.substring(3);
    }
}
