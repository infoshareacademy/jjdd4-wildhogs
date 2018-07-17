<#include "*/common/header.html">

<div>

    <#--zawsze tylko 3-->
    <#if recipesForDefaultCategory??>
    <#list recipesForDefaultCategory as recipe>

    <div><text></text>
            <a href="view-recipe?name=${recipe.name}">
            <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
            <h1>${recipe.name}</h1>
            </a>
        </div>

    </#list>
    <#else>
        <span>There is nothing for ${defaultCategory} for now</span><br/><br/>
    </#if>

    <div>
        <h1>Your fridge contents:</h1>
        <form action="/search-recipe?fridge" method="get">
        <textarea type="text" name="fridge" rows="1" cols="60"></textarea>
        <button>Search</button>
        </form>
    </div>

    <#--zawsze tylko 3-->
    <#if favouriteList??>
        <#list favouriteList as recipe>

        <div>
            <a href="view-recipe?name=${recipe.name}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>

        </#list>
    <#else>
        <span>Your favourites list is empty</span><br/><br/>
    </#if>

</div>

<#include "*/common/footer.html">