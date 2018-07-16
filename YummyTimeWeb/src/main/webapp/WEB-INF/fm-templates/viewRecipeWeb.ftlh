<#include "*/common/header.html">

<div>
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

        <button>Add to shopping list!</button>
        <button>Add to favorites!</button>
    <#else>
        <span>Recipe not found!</span><br/><br/>
    </#if>
</div>

<#include "*/common/footer.html">