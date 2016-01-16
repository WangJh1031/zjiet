<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en-US">
<head>


    <meta charset="utf-8">

    <title>Regedit</title>

    <link href="admin/css/stylesheet.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>
${message}

<div id="login">

    <h2><span class="fontawesome-lock"></span>Regedit</h2>

    <form action="userregedit" method="POST">

        <fieldset>

            <p><label for="email">id</label></p>
            <p><input type="text" id="email" name="uid" ></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->
            <p><label for="email">username</label></p>
            <p><input type="text" id="email1" name="uname" ></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->
            <p><label for="password">Password</label></p>
            <p><input type="password" id="password" name="pwd"></p> <!-- JS because of IE support; better: placeholder="password" -->
            <input type="hidden" value="1" name="level">
            <p><input type="submit" value="Regedit"></p>

        </fieldset>

    </form>

</div> <!-- end login -->

</body>
</html>