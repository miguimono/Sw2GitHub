package co.edu.uptc.sw3.taller3;

 
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author Miguel Angel Nino
 */
@WebFilter(filterName = "FiltroAutenticacion", urlPatterns = {"/Taller3/index.html","/Taller3/ProcesarFormulario"})
public class FiltroAutenticacion implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession().getAttribute("usuario")==null){
            resp.sendRedirect("/login.html");    
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
    
}

