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
            output = getFileContent(this.fileNameOutput);

            outputTemplate = getFileContent(this.fileNameOutputTemplate);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(output);
        assertNotNull(outputTemplate);
        assertEquals(outputTemplate,output);
    }

    private String getFileContent(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
                .reduce("", (sum, item) -> sum + item +"\n");
    }

}