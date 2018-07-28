<#include "*/common/header.html">
<#import "macra/ListOf3BlockRecipe.ftlh" as macro>
<div class="col-10" style="text-align: center;">
    <h1> test ...</h1>
    <div>

    <#--zawsze tylko 3-->
    <#if recipesForDefaultCategory??>
        <h1>There is time for: ${defaultCategory}</h1>
        <@macro.listOf3BlockRecipe list = recipesForDefaultCategory/>
    <#else>
        <span>There is nothing for ${defaultCategory} for now</span><br/><br/>
    </#if>
    </div>

    <div>
        <h1>Your fridge contents:</h1>
        <form action="/search-recipe?fridge" method="get">
        <input type="text" name="fridge" rows="1" cols="60"/>
        <button>Search</button>
        </form>
    </div>
    <div>
    <#--zawsze tylko 3-->
    <#if favouriteList??>
        <@macro.listOf3BlockRecipe list = favouriteList/>
    <#else>
        <span>Your favourites list is empty</span><br/><br/>
    </#if>
    </div>

</div>

<#include "*/common/footer.html">
