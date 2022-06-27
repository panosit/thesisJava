<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <title>Hua Covid-19 Tracker | Sign in</title>
    <style>
        body {
            font-family: "Nunito Sans";
        }
        .login-form {
            padding: 25px;
        }
        h3 {
            padding-left: 30px;
            padding-right: 20px;
            font-weight: 700;
        }
        label {
            padding-top: 4px;
            padding-left: 4px;
        }
        .bg-color {
            background-color: rgb(245, 248, 250);
        }
        .bg-color:hover label {
            color: #31a1f2;
        }
        .btn-custom {
            background-color: black;
            border: none;
            border-radius: 6px;
            font-size: 20px;
            line-height: 28px;
            color: #fff;
            font-weight: 700;
            height: 48px;
        }
        .btn-custom {
            color: #fff !important;
            background-color: #1877f2;
        }
        .form-control {
            border: 0px;
            background-color: rgb(245, 248, 250);
            border-bottom: 2px solid #657786;
            padding: 0px 4px 0px 4px;
            min-height: 20px;
        }
        .form-control:focus {
            box-shadow: none;
            background-color: rgb(245, 248, 250);
            border-color: #31a1f2;
        }
        .fa {
            color: rgb(29, 161, 242);
            margin: 0 auto;
            display: block;
            text-align: center;
            font-size: 50px;
        }
        a {
            text-decoration: none;
            color: rgb(27, 149, 224);
        }
        a:hover {
            text-decoration: underline;
            color: rgb(27, 149, 224);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 p-0 pt-3">
            <h1 class="text-center pt-3">Hua Covid-19 Tracker</h1>
            <form:form action="${pageContext.request.contextPath}/authUser" class="login-form" method="POST">
                <div class="mb-3 bg-color">
                    <label>Username (<b>without</b> @hua.gr)</label>
                    <input type="text" name="username" class="form-control" required>
                </div>
                <div class="mb-3 bg-color">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
                <input type="submit" class="btn btn-custom btn-lg btn-block mt-3" value="Sign in">
                <div class="text-center pt-3 pb-3">
                    <c:if test="${param.error!=null}">
                        <h4>Wrong Password or Username!</h4>
                        <br>
                    </c:if>
                </div>
            </form:form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>