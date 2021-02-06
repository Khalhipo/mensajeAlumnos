<%-- 
    Document   : alumnos2
    Created on : 06-feb-2021, 20:17:17
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
        <h1>Mensaje a alumnos</h1>
        <%
            String grupoSel = (String) request.getAttribute("grupoSel");
            ArrayList<Alumno> alumnosSel = (ArrayList<Alumno>) request.getAttribute("alumnosSel");

        %>
        <form>
            <label for="grupoSel">Grupo seleccionado: <%= grupoSel%><br>
            <table>
                <% for (Alumno al : alumnosSel) {%>
                <tr>
                    <td><%= al.getNombre()%></td>
                    <td><%= al.getApellidos()%></td>
                    <td><%= al.getEmail()%></td>
                </tr>
                <% }%>
            </table>
            <br>
            Mensaje: <textarea id="mensaje"></textarea><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
