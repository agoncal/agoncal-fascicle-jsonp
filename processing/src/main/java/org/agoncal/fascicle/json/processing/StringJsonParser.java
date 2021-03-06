package org.agoncal.fascicle.json.processing;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// TODO create test
public class StringJsonParser {

  public JsonParser parseString() {
    // tag::adocSnippet[]
    StringReader reader = new StringReader("{'hello', 'world'}");
    JsonParser parser = Json.createParser(reader);
    // end::adocSnippet[]
    return parser;
  }

  public JsonParser parseStringProperties() {
    Map properties = null;
    // tag::adocSnippet2[]
    StringReader reader = new StringReader("{'hello', 'world'}");
    JsonParserFactory factory = Json.createParserFactory(properties);
    JsonParser parser = factory.createParser(reader);
    // end::adocSnippet2[]
    return parser;
  }

  public static void main(String[] args) throws FileNotFoundException {
    JsonParser parser = new StringJsonParser().parseString();
    System.out.println(parser.getString());
  }
}
