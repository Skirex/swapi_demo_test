package films;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.Film;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

public class FilmsTest extends BaseTest {

    @Test
    public void getOneFilm() {

        Film film = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + FILMS + "/" + "1")
                .as(Film.class);

        assertThat(film.getEpisode_id()).isEqualTo(4);
        assertThat(film.getCharacters().size()).isEqualTo(18);
        assertThat(film.getCreated()).isEqualTo("2014-12-10T15:23:31.880");
        assertThat(film.getSpecies().size()).isEqualTo(5);
        assertThat(film.getDirector()).isEqualTo("George Lucas");
        assertThat(film.getSpecies().get(0)).isEqualTo("https://swapi.dev/api/species/1/");
    }

    @Test
    public void getFilms() {

        JsonPath jsonPath = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + FILMS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();

        List<Film> returnedFilms = jsonPath.getList("results", Film.class);
        assertThat(returnedFilms.size()).isEqualTo(6);
        assertThat(returnedFilms.get(1).getDirector()).isEqualTo("Irvin Kershner");
        assertThat(returnedFilms.get(1).getEpisode_id()).isEqualTo(5);
    }
}
