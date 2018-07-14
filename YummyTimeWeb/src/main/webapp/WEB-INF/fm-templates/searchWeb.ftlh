<#include "*/common/header.html">

<div>
<#if recipesList??>
<h1>Result of your search by ${parameter}:</h1>
    <#list recipesList as recipe>
        <div>
            <a href="view-recipe?name=${recipe.name}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>
    </#list>
<#else>
    <span>${errorMessage}</span><br/><br/>
</#if>
</div>

<#include "*/common/footer.html">