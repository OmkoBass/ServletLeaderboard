<%-- 
    Document   : ServeContestants
    Created on : Nov 29, 2021, 12:48:52 PM
    Author     : Omer
--%>

<%@page import="java.util.Random"%>
<%@page import="MyClasses.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Serve Contestants</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    
    <style>
        * {
            padding: 0;
            margin: 0;
            font-family: 'Roboto', sans-serif;
        }
        body {
            background-color: #CED4DA;
        }
    </style>
    
    <body>
        <div style="text-align: center; color: #101113;">
            <h1 style="margin-top: 1em;"> The Contestants </h1>
            <h4 style="margin-top: 1em;"> These are the nine randomly drawn contestants we have! </h4>
        </div>
        
        <div style="display: block; margin: auto; text-align: center; max-width: 480px;">
            <%
                // I can also pass a paramter here and use it as args
                // Check the utils class for implementation
                out.println(Utils.serveNContestants(9));
            %>
        </div>
    </body>
</html>
