<%-- 
    Document   : viewnote.jsp
    Created on : 2-Jun-2021, 12:29:11 PM
    Author     : m-navarro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <br>
        <h2>View Note</h2>
        
        <form method="get" action="note">
        <p>Title: ${note.firstLine}</p>
        
        <p>Contents: ${note.secondLine}</p>
        
        
        </form> 
        
  
         <a href ="note?edit">Edit</a>
        
       
        
    </body>
</html>
