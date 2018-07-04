package com.github.greenmarker;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.filefilter.AbstractFileFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Mojo(name = "syncprops")
public class SortPropsApacheCommons extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "Hello, world." );

        //        File dir = new File("src/main/resources/");
//        String bundleName = "Res";
//
//        File defaultFile = new File(dir, bundleName+"_en_GB.properties");
//
//        FileUtils.iterateFiles(dir, new PropertyFileFilter(bundleName),null)
//                .forEachRemaining(file ->
//                        updateProps(file, defaultFile)
//                );
    }

    public static void main(String[] args) throws MojoFailureException, MojoExecutionException {
        new SortPropsApacheCommons().execute();
    }

    private void updateProps(File file, File fileWithDefaults) {
        getLog().info("Updating file: " + file.getName());
        PropertiesConfiguration propsBase = new PropertiesConfiguration();
        PropertiesConfiguration props = new PropertiesConfiguration();

        try {
            propsBase.read(new FileReader(fileWithDefaults));
            props.read(new FileReader(file));
            propsBase.copy(props);

            propsBase.write(new FileWriter(file));
        } catch (ConfigurationException | IOException e) {
            e.printStackTrace();
        }

    }

    private class PropertyFileFilter extends AbstractFileFilter {
        private String bundleName;
        public PropertyFileFilter(String bundleName) {
            this.bundleName = bundleName;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(bundleName+"_") && !name.startsWith(bundleName+"_en_GB") && name.endsWith(".properties");
        }
    }
}
