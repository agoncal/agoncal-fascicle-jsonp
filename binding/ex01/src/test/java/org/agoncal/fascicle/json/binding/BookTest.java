package org.agoncal.fascicle.json.binding;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.agoncal.fascicle.json.UtilTest.initBufferedWriter;
import static org.agoncal.fascicle.json.UtilTest.jsonPath;
import static org.agoncal.fascicle.json.UtilTest.output;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  private static Jsonb jsonb;

  @BeforeAll
  static void init() {
    jsonb = JsonbBuilder.create();
  }

  static BufferedWriter bw;

  @BeforeAll
  static void initFile() throws FileNotFoundException {
    bw = initBufferedWriter("src/test/java/org/agoncal/fascicle/json/binding/BookTest.json");
  }

  @AfterAll
  static void closeFile() throws IOException {
    bw.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldMarshallAnAuthor() throws Exception {

    Book book = new Book("H2G2", 12.5F, "The Hitchhiker's Guide to the Galaxy", "1-84023-742-2", 354, false);
    String json = jsonb.toJson(book);
    output(bw, json, "adocShouldMarshallAnAuthor");

    assertEquals("H2G2", jsonPath(json, "$.book_title"));
    assertEquals(12.5, jsonPath(json, "$.price"));
    assertEquals("The Hitchhiker's Guide to the Galaxy", jsonPath(json, "$.desc"));
    assertEquals("1-84023-742-2", jsonPath(json, "$.isbn"));
    assertEquals(354, jsonPath(json, "$.nb_of_pages"));
    assertEquals(Boolean.FALSE, jsonPath(json, "$.illustrations"));
  }
}