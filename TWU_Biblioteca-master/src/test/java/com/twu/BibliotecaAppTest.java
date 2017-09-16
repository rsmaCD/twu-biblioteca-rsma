package com.twu;

import com.twu.biblioteca.io.FileIO;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BibliotecaAppTest {

    private String fileNameOutput = "output.txt";
    private String fileNameOutputTemplate = "outputTemplate.txt";

    @Test
    public void shouldGetOutputEqualToOutputtemplate() throws Exception {
        FileIO io = new FileIO();
        BibliotecaApp app = new BibliotecaApp(io);
        app.init(io);
        app.run();

        String output = null;
        String outputTemplate = null;

        try {
            output = Files.lines(Paths.get(this.fileNameOutput), StandardCharsets.UTF_8)
                    .reduce("", (sum, item) -> sum + item +"\n");

            outputTemplate = Files.lines(Paths.get(this.fileNameOutputTemplate), StandardCharsets.UTF_8)
                    .reduce("", (sum, item) -> sum + item +"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(output);
        assertNotNull(outputTemplate);
        assertEquals(output,outputTemplate);
    }

}