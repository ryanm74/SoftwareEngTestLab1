package ie.gmit.single;
//Design principal lab
//Ryan Murray
//G00340535
//24/03/20
//User Controller

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity

    //Store used by controller
    private UserPersistenceService persistenceService = new UserPersistenceService();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(userJson, User.class);

        ValidateUser myUser = new ValidateUser();

        boolean checkedUser = myUser.checkUser(user);

        if (!checkedUser) {
            return "ERROR";
        }

        persistenceService.saveUser(user);


        return "SUCCESS";
    }

}