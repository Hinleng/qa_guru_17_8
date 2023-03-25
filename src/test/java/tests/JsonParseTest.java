package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import tests.model.Fruits;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParseTest {

    ClassLoader cl = JsonParseTest.class.getClassLoader();
    ObjectMapper objectmapper = new ObjectMapper();

    @Test
    void jsonParsingTest() throws IOException {

        try (
                InputStream resource = cl.getResourceAsStream("example_fruits.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            Fruits jsonFruits = objectmapper.readValue(reader, Fruits.class);

            assertThat(jsonFruits.color).contains("red");
            assertThat(jsonFruits.weight).isEqualTo(0.25);
            assertThat(jsonFruits.fruits).contains("banana");
            assertThat(jsonFruits.organic).isEqualTo(true);
        }
    }
}
