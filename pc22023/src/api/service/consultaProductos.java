package api.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import api.domain.Aliado;
import api.domain.Consulta;
import api.domain.Producto;
import api.Util;
import javax.ws.rs.core.*;
@Path("/api/v1/Productos")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class consultaProductos {
	@POST
	public Response createConsulta(Consulta consultaRequest) {
		Producto[] obj =null;
		try {
			 obj = Util.apigwProducto(consultaRequest.url, consultaRequest.Codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String htmlResponse = buildHtmlTable(obj);
        return Response.ok(htmlResponse)
                .header("Content-Type", "text/html;charset=UTF-8")
                .build();
	}

    private String buildHtmlTable(Producto[] productos) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><table border='1'>");
        html.append("<tr><th>Categoria</th><th>Codigo</th><th>Descripcion</th><th>Precio S/.</th><th>Presentacion</th></tr>");

        for (Producto producto : productos) {
            html.append("<tr>");
            html.append("<td>").append(producto.Categoria).append("</td>");
            html.append("<td>").append(producto.Codigo).append("</td>");
            html.append("<td>").append(producto.Descripcion).append("</td>");
            html.append("<td>").append(producto.PrecioSol).append("</td>");
            html.append("<td>").append(producto.Presentacion).append("</td>");
            html.append("</tr>");
        }

        html.append("</table></body></html>");
        return html.toString();
    }

}
