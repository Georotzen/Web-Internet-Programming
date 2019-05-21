<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
   $(".delete").click(function(){
       var row = $(this).closest("tr");
       $.ajax({
           url: "AjaxDeleteEntry",
           data: {
               "id" : row.attr("data-entry-id")
           },
           success: function(){
               row.remove();
           }
       });
   });
   
   $("#add").click(function(){
      var name = $("#name").val();
      var message = $("#message").val();
      if( name != "" && message != "" )
          $.ajax({
              url: "AjaxAddEntry",
              data: {
                  "name": name,
                  "message": message
              },
              success: function(data){
                  var row = $("<tr data-entry-id='" + data + "'></tr>" );
                  row.append("<td>" + name + "</td>");
                  row.append("<td>" + message + "</td>");
                  row.append("<td><button>Delete</button></td>");
                  $("#form").before(row);
              }
          });
   });
   
   $(".editName").dblclick(function(){
       var input = $("<input type='text'/>").val($(this).text());
       input.blur(function(){
          var value = $(this).val();
          td.empty().text(value);
       });
       $(this).empty().append(input);
   });
   
   $(".editName").focusout(function(){
	   var input = $("<input type='text'/>").val($(this).text());
	   $.ajax({
           url: "AjaxAddEntry",
           data: {
               "name": name,
               "id": $(this).id
           },
           success: function(){
				
           }
       });
   });
   
});
</script>
</head>
<body>
<h2>GuestBook</h2>
<table border="1">
  <tr><th>Name</th><th>Message</th><th></th></tr>
  <c:forEach items="${entries}" var="entry">
  <tr data-entry-id="${entry.id}">
    <td class="edit">${entry.name}</td>
    <td class="edit">${entry.message}</td>
    <td><button class="delete">Delete</button></td>
  </tr>
  </c:forEach>
  <tr id="form">
    <td><input id="name" type="text" /></td>
    <td><input id="message" type="text" /></td>
    <td><button id="add">Add</button></td>
</table>
</body>
</html>