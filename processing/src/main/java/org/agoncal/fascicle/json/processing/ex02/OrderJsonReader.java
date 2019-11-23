package org.agoncal.fascicle.json.processing.ex02;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderJsonReader {

  public JsonObject readPurchaseOrder() throws FileNotFoundException {
    // tag::adocsnippet[]
    JsonReader reader = Json.createReader(new FileReader("src/main/resources/order.json"));
    JsonObject jsonObject = reader.readObject();
    jsonObject = jsonObject.getJsonObject("order");
    // end::adocsnippet[]
    return jsonObject;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(new OrderJsonReader().readPurchaseOrder());
  }
}