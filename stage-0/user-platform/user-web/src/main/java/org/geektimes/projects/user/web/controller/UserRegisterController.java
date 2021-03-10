package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserRegisterController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService;

    @Override
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));

        if (userService.register(user)) {
            return "register-success.jsp";
        }
        return "register-error.jsp";
    }
}
