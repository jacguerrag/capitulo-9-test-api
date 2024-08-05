package api.steps;

import api.models.User;
import api.models.User2;
import api.utilities.ApiHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserUpdateSteps {

    private Response responseUpdate;
    private Response responsePartialUpdate;
    private User2 user2;
    private User2 userPartialUpdated;


    @Given("Yo actualizo el usuario {string} con el nombre {string} y trabajo {string}")
    public void actualizacionUsuario(String id, String name, String job)
    {
        User2 newUser = new User2(job,name);
        responseUpdate = ApiHelper.updateUser(id, newUser);
        user2 = responseUpdate.as(User2.class);
    }

    @Then("Yo deberia ver el status 200 y nombre y trabajo actualizados")
    public void validarUsuarioActualizado()
    {
        assertThat("El codigo de respuesta debe ser 200",200, is(responseUpdate.getStatusCode()));
        assertThat("El nombre debe ser","Jose",is(user2.getName()));
        assertThat("El trabajo debe ser","Product Manager",is(user2.getJob()));

    }

    @Given("Yo realizo la actualizacion parcial del usuario {string} con el trabajo {string}")
    public void parcialActualizacionUsusario(String id, String job)
    {
        User2 newUser = new User2(job);
        responsePartialUpdate = ApiHelper.partialUpdateUser(id, newUser);
        userPartialUpdated = responsePartialUpdate.as(User2.class);
    }

    @Then("Yo deberia de ver el campo job actualizado con el nuevo cargo")
    public void validarUsuarioParcialActualizado(){
        assertThat("El codigo de respuesta debe ser 200",200, is(responsePartialUpdate.getStatusCode()));
        assertThat("El trabajo debe ser","Project Manager",is(userPartialUpdated.getJob()));
    }
}
