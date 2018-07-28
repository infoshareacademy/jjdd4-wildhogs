<#include "*/common/header.html">
<#import "macra/ListOf3BlockRecipe.ftlh" as macro>

<div class="col-10" style="text-align: center;">

    <div>
    <#if recipesForDefaultCategory??>
        <h1>There is time for: ${defaultCategory}</h1>
        <@macro.listOf3BlockRecipe list = recipesForDefaultCategory/>
        <div>
            <h1>Your fridge contents:</h1>
            <form action="/search-recipe?fridge" method="get">
                <input type="text" name="fridge" rows="1" cols="60"/>
                <button>Search</button>
            </form>
        </div>
    <#else>
        <div class="alert alert-danger" role="alert">
            There are no recipes, please load JSON file!
        </div>
    </#if>
    </div>

    <div>
        <#if favouriteList??>
            <@macro.listOf3BlockRecipe list = favouriteList/>
        </#if>
    </div>

</div>

<#include "*/common/footer.html">
