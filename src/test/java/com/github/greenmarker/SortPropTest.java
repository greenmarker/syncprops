package com.github.greenmarker;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.jupiter.api.Test;

public class SortPropTest {

    @Test
    public void test() throws MojoFailureException, MojoExecutionException {
        SortPropsApacheCommons spac = new SortPropsApacheCommons();
        // given

        //dir: target/classes/

        // when
        spac.execute();
        // then
    }
}
