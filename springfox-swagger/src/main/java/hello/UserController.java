package hello;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Controller
@RequestMapping(value = "/api/user", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/user", description = "User Information")
public class UserController {

    static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(
            value = "Find user by ID", notes = "Returns a user by ID",
            response = User.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found")}
    )
    public ResponseEntity<User> getUserById(
            @PathVariable("userId") String userId) {
        logger.debug(userId);
        User u = null;
        if ("1".equals(userId)) {
            u = new User();
            u.setName("tom");
            u.setProfile("my name is tom");
            logger.debug(u.toString());
        }
        return Optional
                .ofNullable(u)
                .map(user -> ResponseEntity.ok().body(user))          //200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
