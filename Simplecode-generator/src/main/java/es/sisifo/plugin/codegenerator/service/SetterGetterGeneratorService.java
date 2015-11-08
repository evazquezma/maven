package es.sisifo.plugin.codegenerator.service;



public interface SetterGetterGeneratorService {

    public abstract String generateSetters(Class<?> clazz, String nombreObj1, String nombreObj2);

}