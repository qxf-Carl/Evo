package org.geektimes.projects.user.web.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Path("/user")
public class UserRegisterController implements PageController {

    private final UserService userService;

    public UserRegisterController() {
        userService = new UserServiceImpl();
    }

    @Override
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> bodyParamsMap = objectMapper.readValue(body, HashMap.class);

        User user = new User();
        user.setName(bodyParamsMap.get("name"));
        user.setPassword(bodyParamsMap.get("password"));
        user.setEmail(bodyParamsMap.get("email"));
        user.setPhoneNumber(bodyParamsMap.get("phoneNumber"));
        return userService.register(user) ? "register-success.jsp" : "register-error.jsp";
    }
}
