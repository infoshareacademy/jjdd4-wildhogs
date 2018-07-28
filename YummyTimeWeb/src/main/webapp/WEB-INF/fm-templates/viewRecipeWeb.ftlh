<#include "*/common/header.html">
<div style="text-align: center;" class="col-10">

<div class="col-10" style="text-align: center;">
    <#if message??>
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </#if>
    <#if recipe??>
        <h1>${recipe.name}</h1>
        <p>${recipe.category}</p>
        <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="500">
        <ul>
        <#list recipe.ingredientsList as value>
            <li>${value.name} ${value.amount} ${value.unit.description}</li>
        </#list>
        </ul>
        <p>${recipe.description}</p>

        <form method="post" action="/to-shoppingList?id=${recipe.id}">
            <button>Add to shopping list!</button>
        </form> <br><br>

        <form method="post" action="/to-favorite?id=${recipe.id}">
            <button>Add to favorites!</button>
        </form>
    <#else>
        <div class="alert alert-danger" role="alert">
            Recipe not found!
        </div>
    </#if>
</div>
</div>
<#include "*/common/footer.html">
