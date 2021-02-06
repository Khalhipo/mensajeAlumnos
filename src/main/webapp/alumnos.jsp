<%-- 
    Document   : alumnos
    Created on : 04-feb-2021, 13:51:38
    Author     : Bueno
--%>

<%@page import="modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Mensaje a alumnos</h1
        
        <% String grupoSel = (String) request.getAttribute("grupoSel");
           ArrayList<String> grupos = (ArrayList<String>) request.getAttribute("grupos");
           ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("alumnos");
            
            %>

        <h5>Grupo Seleccionado: <%= grupoSel %></h5>
        <form action="ServletAlumnos" method="get">
            <label for="grupo">Grupo: </label><select name="grupo">
                <% for (String grupo : grupos) {
                        String textoSelected = "";
                        if (grupo.equalsIgnoreCase(grupoSel)) {
                            textoSelected = "selected";
                        }
                %>
                <option <%= textoSelected%> value="<%= grupo%>"><%= grupo%></option>
                <% }%>
            </select><br>
            <input type="submit" value="Seleccionar">
        </form>
            <br>
            <form action="ServletAlumnos" method="post">
                <label for="grupoSel">Grupo seleccionado: </label><input name="grupoSeleccionado" id="grupoSel" type="text" value="<%= grupoSel %>"><br>
                <table>
                    <% for(Alumno al: alumnos) { %>
                    <tr>
                        <td><%= al.getNombre()%></td>
                        <td><%= al.getApellidos()%></td>
                        <td><%= al.getEmail() %></td>
                        <td><input name="checkbox" type="checkbox" value="<%= al.getId() %>"></td>
                    </tr>
                    <% } %>
                </table>
                <input type="submit" value="Enviar">
            </form>
    </body>
</html>
