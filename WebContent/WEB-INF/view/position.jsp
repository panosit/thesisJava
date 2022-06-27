<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <title>Hua Covid-19 Tracker | Position</title>
    <style>
        .navigation {
            height: 70px;
            background:black;
        }


        .brand {
            position: absolute;
            padding-left: 20px;
            float: left;
            line-height: 70px;
            text-transform: uppercase;
            font-size: 1.4em;
        }
        .brand a,
        .brand a:visited {
            color: #ffffff;
            text-decoration: none;
        }

        .nav-container {
            max-width: 1000px;
            margin: 0 auto;
        }

        nav {
            float: right;
        }
        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            float: left;
            position: relative;
        }
        nav ul li a,
        nav ul li a:visited {
            display: block;
            padding: 0 20px;
            line-height: 70px;
            background: black;
            color: #ffffff;
            text-decoration: none;
        }
        nav ul li a:hover,
        nav ul li a:visited:hover {
            background: black;
            color: #ffffff;
        }
        nav ul li a:not(:only-child):after,
        nav ul li a:visited:not(:only-child):after {
            padding-left: 4px;
            content: " ▾";
        }
        nav ul li ul li {
            min-width: 190px;
        }
        nav ul li ul li a {
            padding: 15px;
            line-height: 20px;
        }

        .nav-dropdown {
            position: absolute;
            display: none;
            z-index: 1;
            box-shadow: 0 3px 12px rgba(0, 0, 0, 0.15);
        }

        .nav-mobile {
            display: none;
            position: absolute;
            top: 0;
            right: 0;
            background: #262626;
            height: 70px;
            width: 70px;
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
    </style>
</head>
<body>
<sec:authorize access="hasRole('USER')">
    <section class="navigation">
        <div class="nav-container">
            <div class="brand">
                <a href="<c:url value="/index1" />">Hua Covid-19 Tracker</a>
            </div>
            <nav>
                <ul class="nav-list">
                    <li>
                        <a style="color: white;">${username}</a>
                    </li>
                    <li>
                        <a href="<c:url value="/covid1" />">Δήλωση Κρούσματος Covid-19</a>
                    </li>
                    <li>
                        <a href="<c:url value="/show1" />">Show All Data</a>
                    </li>
                    <li>
                        <a href="<c:url value="/logout" />">Log out</a>
                    </li>
                </ul>
            </nav>
        </div>
    </section>
    <br><br><br>
    <h2 style="text-align: center;">Σημερινές Διαλέξεις</h2>
    <table style="width: 100%; margin: 40px;">
        <thead>
        <tr>
            <th>Μάθημα</th>
            <th>Καθηγητής</th>
            <th>Τύπος μαθήματος</th>
            <th>Ημερομηνία</th>
            <th>Ωρα έναρξης</th>
            <th>Ωρα λήξης</th>
            <th>Αίθουσα</th>
        </tr>
        </thead>
        <tbody>
            <tr class="even:bg-gray-50">
                <td class="py-4 px-6">${lecture.lesson}</td>
                <td class="py-4 px-6">${lecture.professor}</td>
                <td class="py-4 px-6">${lecture.lesson_type}</td>
                <td class="py-4 px-6">${lecture.date}</td>
                <td class="py-4 px-6">${lecture.starting_hour}</td>
                <td class="py-4 px-6">${lecture.ending_hour}</td>
                <td class="py-4 px-6">${lecture.amphitheater}</td>
            </tr>
        </tbody>
    </table>
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 p-0 pt-3">
                <h2 style="text-align: center;">Εισάγετε τον αριθμό της θέσης σας</h2><br>
                <form class="login-form" action="/lectures/${lecture.lecture_id}/addPosition" method="POST">
                    <div class="mb-3 bg-color">
                        <label>Αριθμός θέσης</label>
                        <input type="text" name="positionNumber" class="form-control" required>
                    </div>
                    <input type="submit" class="btn btn-custom btn-lg btn-block mt-3" value="Εισαγωγή">
                    <div class="text-center pt-3 pb-3">
                        <h4>${result}</h4>
                    </div>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</sec:authorize>
</body>
</html>