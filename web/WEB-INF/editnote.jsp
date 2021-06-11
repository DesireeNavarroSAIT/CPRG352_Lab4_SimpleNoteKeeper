<%-- 
    Document   : editnote
    Created on : 2-Jun-2021, 12:29:26 PM
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
        
        <form method="post" action="note">
            
        <label>Title: </label>
        <input type="text" name="title" value="${note.firstLine}"><br><br>
        
        <label>Contents </label>
        <textarea name="contexts">${note.secondLine}</textarea><br><br>

        <input type="submit" value="Save">
        </form>  
    </body>
</html>
