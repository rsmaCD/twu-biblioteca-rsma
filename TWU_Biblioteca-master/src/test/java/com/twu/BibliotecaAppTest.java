package com.twu;

import com.twu.biblioteca.io.FileIO;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private String fileNameOutput = "output.txt";
    private String fileNameOutputTemplate = "outputTemplate.txt";

    @Test
    public void should_get_output_equal_to_outputtemplate() throws Exception {
        FileIO io = new FileIO();
        BibliotecaApp app = new BibliotecaApp(io);
        app.init(io);
        app.run();

        List<String> output = new ArrayList<>();
        List<String> outputTemplate = new ArrayList<>();

        try {
            output = Files.lines(Paths.get(this.fileNameOutput), StandardCharsets.UTF_8)
                    .collect(java.util.stream.Collectors.toList());

            outputTemplate = Files.lines(Paths.get(this.fileNameOutputTemplate), StandardCharsets.UTF_8)
                    .collect(java.util.stream.Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(output,outputTemplate);
    }

}