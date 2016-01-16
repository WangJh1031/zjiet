<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en-US">
<head>


    <meta charset="utf-8">

    <title>Login</title>

    <link href="css/stylesheet.css" rel="stylesheet">
    <link href="admin/css/stylesheet.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>
${message}

<div id="login">

    <h2><span class="fontawesome-lock"></span>Sign In</h2>

    <form action="loginservlet" method="POST">

        <fieldset>

            <p><label for="email">username</label></p>
            <p><input type="text" id="email" name="uid" ></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->

            <p><label for="password">Password</label></p>
            <p><input type="password" id="password" name="pwd"></p> <!-- JS because of IE support; better: placeholder="password" -->

            <p><input type="submit" value="Sign In"></p>

        </fieldset>

    </form>

</div> <!-- end login -->

</body>
</html>