<!DOCTYPE html>
<html lang="en" xmlns="http://java.sun.com/jsf/html">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <meta charset="UTF-8">
    <title>YummyTime</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="907007146976-gj3molj87dk4k7jntu3hslrdubmd1947.apps.googleusercontent.com">

</head>

<style>
    .card {
        margin: 30px auto;
    }

    .name {
        padding: 0px auto;
        margin: 0px 50px;
        text-align: center;
    }
    .menu-button{
        border-radius: 50px;
        color: white;
        font-weight: bold;
    }
    .menu-button:hover{
        color: darkorange;
        font-weight: bold;

    }
    .dropdown-item:hover{
        font-weight: bold;
    }

    .dropdown-item:hover{
        background-color: darkorange;
        color: white;
        font-weight: bold;

    }
    .search{
        margin: 30px 0px 30px;
    }

</style>
<body background=white">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<div class="HEADER">

    <div class="jumbotron jumbotron-fluid text-white" style="background:darkorange;border-radius: 0px 0px 20px 20px">
        <div></div>

        <div class="container">
            <a href="/welcome" style="text-decoration: none;color: white"><h1 class="name">YummyTime</h1></a>
        </div>
        <br>
        <br>
        <nav class="nav justify-content-center">

            <li class="nav-item">
                <a class="menu-button" href="welcome" class="text-white">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="menu-button" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">Category</a>
                <div class="dropdown-menu">
                    <a href="search-recipe?category=breakfast" class="dropdown-item">Breakfast</a>
                    <a href="search-recipe?category=lunch" class="dropdown-item">Lunch</a>
                    <a href="search-recipe?category=dinner" class="dropdown-item">Dinner</a>
                    <a href="search-recipe?category=supper" class="dropdown-item">Supper</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="menu-button" href="/shopping-list" class="text-white">Shopping List</a>
            </li>
            <li class="nav-item">
                <a class="menu-button" href="/statistics" class="text-white">Statistic</a>
            </li>
            <li class="nav-item">
                <a class="menu-button" href="/about" class="text-white">Our Team</a>
            </li>
            <li class="nav-item">
                <a class="menu-button" href="/contact" class="text-white">Contact</a>
            </li>
            <#if logged??>
                <li>
                    <a class="menu-button" id="logout" href="/logout-gmail" class="text-white">Sign out</a>
                </li>
            <#else >
                <li class="nav-item">
                    <a class="menu-button" href="/gmail-login" class="text-white">Login</a>
                </li>
            </#if>

        </nav>

    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col">
            </div>

