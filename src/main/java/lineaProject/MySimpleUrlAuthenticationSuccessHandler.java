package lineaProject;

import lineaProject.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
User user =(User) authentication.getPrincipal();
String roles = user.getRole();
if(roles.equals("ROLE_ADMIN")){
    httpServletResponse.sendRedirect("/admin/dashboard");

}else if(roles.equals("ROLE_CLIENT")) {
    httpServletResponse.sendRedirect("/user/dashboard");
}else {
    httpServletResponse.sendRedirect("/worker/dashboard");
}
    }
}
