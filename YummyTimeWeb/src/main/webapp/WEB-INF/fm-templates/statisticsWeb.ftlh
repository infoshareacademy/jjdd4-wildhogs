<!DOCTYPE html>
<html lang="en" xmlns="http://java.sun.com/jsf/html">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <meta charset="UTF-8">
    <title>YummyTime</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

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
                ['Breakfast', 3],
                ['Lunch', 1],
                ['Dinner', 2],
                ['Supper', 1]
            ]);

            // Set chart options
            var options = {'title':'Popularity of category',
                'width':800,
                'height':800};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
            chart.draw(data, options);

        }
    </script>
    <script type="text/javascript">
        google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawBasic);

        function drawBasic() {

            var data = google.visualization.arrayToDataTable([
                ['Recipe', 'Visits number',],
                ['recipe1', 2],
                ['recipe2', 3],
                ['recipe3', 1],
                ['recipe4', 7],
                ['recipe5', 2]
            ]);

            var options = {
                title: 'Popularity of recipe',
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

</head>

<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>



<div class = "HEADER">

    <ul>
        <div style="text-align: center;">

            <link><a href="welcome"><option value="">Home</option></a></link>
            <link><a href="welcome"><option value="">Category</option></a></link>
            <ul><link><a href="search-recipe?category=breakfast"><option value="">Breakfast</option></a></link>
                <a href="search-recipe?category=lunch"> <option value="/category/lunch">Lunch</option></a></link>
                <a href="search-recipe?category=dinner"> <option value="/category/dinner">Dinner</option></a></link>
                <a href="search-recipe?category=supper"><option value="/category/supper">Supper</option></a></link>
            </ul>
            <link><a href="/shopping-list"><option value="">Shopping List</option></a></link>

            <link><a href="view-recipe?OurTeam"><option value="">OurTeam</option></a></link>

            <link><a href="view-recipe?contact"><option value="">Contact</option></a></link>

            <link><a href="/statistics"><option value="">Statistics</option></a></link>

        </div>
    </ul>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col" style="background: orange;" > TestLeft
        </div>


        <div class="col-10" style="text-align: center;">
            <div id="chart_div1"></div>
            <div id="chart_div2"></div>
            </div>
<#include "*/common/footer.html">
