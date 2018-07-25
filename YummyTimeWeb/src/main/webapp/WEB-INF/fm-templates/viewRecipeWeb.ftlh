<#include "*/common/header.html">

<div>
    <#if message??>
        <span>${message}</span>
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

        <form method="post" action="/to-shoppingList?name=${recipe.id}">
            <button>Add to shopping list!</button>
        </form>

        <form method="post" action="/to-favorite?name=${recipe.id}">
            <button>Add to favorites!</button>
        </form>
    <#else>
        <span>Recipe not found!</span><br/><br/>
    </#if>
</div>

<#include "*/common/footer.html">