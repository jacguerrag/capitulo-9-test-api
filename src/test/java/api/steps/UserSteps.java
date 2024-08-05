package api.steps;

import api.models.User;
import api.utilities.ApiHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserSteps {
    private Response response;
    private User user;
    private User consultateUser;

    @Given("Yo creo un nuevo usuario con email {string} nombre {string} apellido {string} y avatar {string}")
    public void crearUsuario(String email, String first_name, String last_name, String avatar )
    {
        User newUser = new User(email, first_name, last_name, avatar);
        response = ApiHelper.createUser(newUser);
        user = response.as(User.class);
    }

    @Then("Yo deberia de ver un codigo de respuesta 201 y en la respuesta el id nombre y marca de tiempo no vacios")
    public void verificarUsuarioCreado()
    {
        assertThat("El codigo de respuesta debe ser 201",201, is(response.getStatusCode()));
        assertThat("El id no deberia estar vacio",user.getId(), notNullValue());
        assertThat("La fecha de creacion no debe estar vacio",user.getCreatedAt(), notNullValue());

    }

    @Given("Yo realizo la consulta de un usuario con ID {string}")
    public void consultarUsuario(String id)
    {
        response = ApiHelper.consultUser(id);

        try {
            JsonPath jsonPath = response.getBody().jsonPath();
            Map<String, Object> dataMap = jsonPath.getMap("data");

            ObjectMapper objectMapper = new ObjectMapper();
            consultateUser = objectMapper.convertValue(dataMap, User.class);
            System.out.println(consultateUser.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("Yo puedo validar el codigo de estado en 200 y los campos email nombre apellido y avatar.")
    public void validarUsuarioConsultado()
    {
        assertThat("El codigo de respuesta debe ser 200",200, is(response.getStatusCode()));
        assertThat("El ID debe ser 2",consultateUser.getId(),is("2"));
        assertThat("El email debe ser janet.weaver@reqres.in",consultateUser.getEmail(),is("janet.weaver@reqres.in"));
        assertThat("El primer nombre debe ser Janet",consultateUser.getFirst_name(),is("Janet"));
        assertThat("El primer apellido debe ser Weaver",consultateUser.getLast_name(),is("Weaver"));
    }
}
