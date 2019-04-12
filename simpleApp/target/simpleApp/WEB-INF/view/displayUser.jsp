<%--
  Created by IntelliJ IDEA.
  User: arpit
  Date: 12/4/19
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="application/javascript">
        $("document").ready(function () {
            $("#clickMe").click(function () {
              var data = {};
              data.userName = $("#user").val();
              data.password = $("#password").val();

              $.ajax({
                  type : "POST",
                  url : "/submitUser",
                  contentType : "application/json",
                  dataType : "json",
                  success : function (result) {
                      alert("Hey buddy");
                  }
              })
            })
        })
    </script>
</head>
<body>
    <input type="text" id="user">
    <input type="password" id="password">
    <input type="button" id="clickMe">
</body>
</html>
