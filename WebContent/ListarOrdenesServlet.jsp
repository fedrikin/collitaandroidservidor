<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.fedesoft.collitaservidor.CollitaDAOJPA"%>
<%@page import="com.fedesoft.collitaservidor.CollitaDAOIfc"%>
<%@page import="com.fedesoft.collitaservidor.model.OrdenCollita"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String fecha=request.getParameter("fecha");
%>

<title>Ordenes de collita del día: <% out.print(fecha); %> </title>
<script>
function printpage()
  {
  window.print()
  }
</script>

</head>
<body>

<%
	CollitaDAOJPA collitaDAO = new CollitaDAOJPA();	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	List<OrdenCollita> ordenes=collitaDAO.recuperarOrdenesCollita(sdf.parse(fecha));	
	Collections.sort(ordenes,new Comparator<OrdenCollita>(){
		@Override
		public int compare(OrdenCollita o1, OrdenCollita o2) {
			return o1.getVariedad().getNombre().compareTo(o2.getVariedad().getNombre());		
		}});

%>
<table>
	<thead>
		<td>Cuadrilla</td>
		<td>Camió</td>
		<td>Varietat</td>
		<td>Terme</td>
		<td>Comprador</td>
		<td>Caixons</td>
		<td>Propietari</td>		
	</thead>
	<tbody>	
	<%
	for (OrdenCollita orden:ordenes){
		out.print("<tr>");
		out.println("<td>"+orden.getCuadrilla().getNombre()+"</td>");
		out.println("<td>"+orden.getCamion().getNombre()+"</td>");
		out.println("<td>"+orden.getVariedad().getNombre()+"</td>");
		out.println("<td>"+orden.getTerme().getNombre()+"</td>");
		out.println("<td>"+orden.getComprador().getNombre()+"</td>");
		out.println("<td>"+orden.getCajonesPrevistos()+"</td>");
		out.println("<td>"+orden.getPropietario()+"</td>");			
		out.print("</tr>");		
	}
	%>
	
	</tbody>

</table>

<input type="button" value="Imprimir" onclick="printpage()">

</body>
</html>