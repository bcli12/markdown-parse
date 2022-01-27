import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
public class MarkdownParseTest {
    /*
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    */
    @Test
    public void tester() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        //expected.add("https://something.com");
        //expected.add("some-page.html");
        expected.add("");
        List<String> list = List.of("empty-link.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

}
