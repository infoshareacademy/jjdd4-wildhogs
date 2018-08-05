<#include "*/common/header.ftlh">

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

<div class="col-8" style="text-align: center;">
    <div id="chart_div1" style="margin: 0px 300px 0px;"></div>
    <div id="chart_div2"></div>
</div>

<#include "*/common/footer.ftlh">
