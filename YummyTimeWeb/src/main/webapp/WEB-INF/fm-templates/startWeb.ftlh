<#include "*/common/header.html">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>
<div>

    <#--zawsze tylko 3-->
    <#if recipesForDefaultCategory??>
        <@macro.listBlockRecipe list = recipesForDefaultCategory/>
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
        <@macro.listBlockRecipe list = favouriteList/>
    <#else>
        <span>Your favourites list is empty</span><br/><br/>
    </#if>

</div>

<#include "*/common/footer.html">