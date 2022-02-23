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
        expected.add("https://something.com");
        expected.add("some-page.html");
        List<String> list = List.of("test-file.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

    @Test
    public void testNoFile() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        //expected.add("https://something.com");
        //expected.add("some-page.html");
        //expected.add("");
        List<String> list = List.of("not-a-link.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

    @Test
    public void testSnippet1() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("url.com");
        expected.add("`google.com");
        List<String> list = List.of("snippet1.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

    @Test
    public void testSnippet2() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.com");
        expected.add("b.com");
        expected.add("a.com(())");
        expected.add("example.com");
        List<String> list = List.of("snippet2.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

    @Test
    public void testSnippet3() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.twitter.com");
        expected.add("https://ucsd-cse15l-w22.github.io/");
        expected.add("github.com");
        expected.add("https://cse.ucsd.edu/");
        List<String> list = List.of("snippet3.md");
        for (String string : list) {
            Path fileName = Path.of(string);
	        String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected, links);
        }
    }

}
