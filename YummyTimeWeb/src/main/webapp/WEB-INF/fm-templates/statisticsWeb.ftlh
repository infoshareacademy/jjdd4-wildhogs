<!DOCTYPE html>
<html lang="en" xmlns="http://java.sun.com/jsf/html">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <meta charset="UTF-8">
    <title>YummyTime</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"></head>

<style>
    .card{
        margin: 30px auto;
    }
    .name{
        padding: 0px auto;
        margin: 0px 50px;
    }

</style>
<body background = white">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');

        data.addRows([
           <#if categoryStatistic??>

                <#list categoryStatistic as categoryStatistic>
                ['${categoryStatistic.name}', ${categoryStatistic.quantity}]
                    <#sep>,</#sep>
                </#list>
           </#if>
        ]);

        // Set chart options
        var options = {'title':'Popularity of category',
            'width':500,
            'height':500};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
        chart.draw(data, options);
    }
</script>
<script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);
    function drawBasic() {

           <#if recipeStatistic??>
            var data = google.visualization.arrayToDataTable([
                ['Recipe', 'Visits number',],
                <#list recipeStatistic as recipeStatistic>
                ['${recipeStatistic.name}', ${recipeStatistic.quantity}]
                    <#sep>,</#sep>
                </#list>
            ]);
           </#if>

        var options = {
            title: 'Top 5 recipes popularity',
            chartArea: {width: '50%'},
            hAxis: {
                title: 'Visits number',
                minValue: 0
            },
            vAxis: {
                title: 'Recipes'
            }
        };
        var chart = new google.visualization.BarChart(document.getElementById('chart_div2'));
        chart.draw(data, options);
    }
</script>
<div class = "HEADER">
    <div class="jumbotron jumbotron-fluid text-white" style="background: gray">
        <div class="container">
            <h1 class="name">YummyTime</h1>
        </div>
        <nav class="nav justify-content-center">
            <li class="nav-item">
                <a href="welcome" class="text-white">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Category</a>
                <div class="dropdown-menu">
                    <a href="search-recipe?category=breakfast" class="dropdown-item">Breakfast</a>
                    <a href="search-recipe?category=lunch" class="dropdown-item">Lunch</a>
                    <a href="search-recipe?category=dinner" class="dropdown-item">Dinner</a>
                    <a href="search-recipe?category=supper" class="dropdown-item">Supper</a>
                </div>
            </li>
            <li class="nav-item">
                <a href="/shopping-list" class="text-white">Shopping List</a>
            </li>
            <li class="nav-item">
                <a href="/statistics" class="text-white">Statistic</a>
            </li>
            <li class="nav-item">
                <a href="/About.html" class="text-white">Our Team</a>
            </li>
            <li class="nav-item">
                <a href="/Contact.html" class="text-white">Contact</a>
            </li>

        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col">
            </div>
            <div class="col-8" style="text-align: center;">
                <div id="chart_div1" style="margin: 0px 300px 0px;"></div>
                <div id="chart_div2"></div>
            </div>
<#include "*/common/footer.html">