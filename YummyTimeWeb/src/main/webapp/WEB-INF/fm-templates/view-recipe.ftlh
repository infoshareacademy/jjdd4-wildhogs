<#--<#include "/header.html">-->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


<div>

    <#if errorMessage??>
        <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    </#if>

    <#if recipe??>
        <h1>${recipe.name}</h1>
        <p>${recipe.category}</p>
    
        <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="500">


        <#list recipe.ingredientsMap as key, value>

            <ul>

                    <li>${key} ${value.amount} ${value.unit.description}</li>


            </ul>
        </#list>



        <p>${recipe.description}</p>

    </#if>
</div>


</body>
</html>
<#--<#include "WEB-INF/fm-templates/footer.html">-->