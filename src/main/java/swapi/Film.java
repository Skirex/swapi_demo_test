package swapi;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Film {

    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private Date created;
    private Date edited;
    private String url;
}
