package org.agoncal.fascicle.json.binding;

import javax.json.bind.annotation.JsonbTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class CD {

  private String title;
  private Float price;
  private String description;
  @JsonbTransient
  private List<Artist> createdByArtists;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public CD() {
  }

  public CD(String title, Float price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Artist> getCreatedByArtists() {
    return createdByArtists;
  }

  public void setCreatedByArtists(List<Artist> createdByArtists) {
    this.createdByArtists = createdByArtists;
  }

  public void createdBy(Artist artist) {
    if (createdByArtists == null)
      createdByArtists = new ArrayList<Artist>();
    createdByArtists.add(artist);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]