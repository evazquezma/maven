package es.sisifo.plugin.codegenerator.mojos;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import es.sisifo.plugin.codegenerator.service.SetterGetterGeneratorService;
import es.sisifo.plugin.codegenerator.service.SetterGetterGeneratorServiceImpl;


/**
 * Generador de código crud básico.
 * 
 * @goal setter-getter
 * 
 * @phase process-sources
 */
public class SetterGetterGenerator extends AbstractMojo {

    /**
     * Nombre de la clase del objeto sobre el que se extraerán los setters.
     * 
     * @parameter expression="${className}"
     */
    private String className;

    /**
     * Nombre del objeto que hará los setter
     * 
     * @parameter expression="${objectSet}"
     */
    private String objectSet;

    /**
     * Nombre del objeto que hará los getter
     * 
     * @parameter expression="${objectGet}"
     */
    private String objectGet;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("------------------------------------------------------------");
        getLog().info("Parametro className:" + className);
        getLog().info("Parametro objectSet:" + objectSet);
        getLog().info("Parametro objectGet:" + objectGet);
        getLog().info("------------------------------------------------------------");

        final SetterGetterGeneratorService setterGetterGeneratorService = new SetterGetterGeneratorServiceImpl();
        String codigo = "";
        try {
            codigo = setterGetterGeneratorService.generateSetters(Class.forName(className), objectSet, objectGet);
        } catch (final ClassNotFoundException e) {
            getLog().error("Error al generar código", e);
            return;
        }

        getLog().info("Código resultante:");
        getLog().info("\n" + codigo + "\n");

    }
}
