package api.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import api.Util;
import  api.domain.*;
import javax.ws.rs.core.*;

@Path("/api/v1/Aliados")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class consultaAliados {
	
	@POST
	public Response createConsulta(Consulta consultaRequest) {
		Aliado[] obj =null;
		try {
			 obj = Util.apigwAliados(consultaRequest.url, consultaRequest.Codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String htmlResponse = buildHtmlTable(obj);
        return Response.ok(htmlResponse)
                .header("Content-Type", "text/html;charset=UTF-8")
                .build();
	}

    private String buildHtmlTable(Aliado[] aliados) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><table border='1'>");
        html.append("<tr><th>Apertura</th><th>Categoria</th><th>Codigo</th><th>Negocio</th></tr>");

        for (Aliado aliado : aliados) {
            html.append("<tr>");
            html.append("<td>").append(aliado.Apertura).append("</td>");
            html.append("<td>").append(aliado.Categoria).append("</td>");
            html.append("<td>").append(aliado.Codigo).append("</td>");
            html.append("<td>").append(aliado.Negocio).append("</td>");
            html.append("</tr>");
        }

        html.append("</table></body></html>");
        return html.toString();
    }

}