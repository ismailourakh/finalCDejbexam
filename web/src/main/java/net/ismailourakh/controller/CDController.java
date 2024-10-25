import com.example.service.CDService;
import com.example.entity.CD;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cds")
public class CDController extends HttpServlet {

    @EJB
    private CDService cdService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CD> cds = cdService.findAllCDs();
        request.setAttribute("cds", cds);
        request.getRequestDispatcher("/views/cd/cdList.jsp").forward(request, response);
    }
}
