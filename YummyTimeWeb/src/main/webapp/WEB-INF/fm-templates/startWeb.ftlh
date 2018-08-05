<#include "*/common/header.ftlh">
<#import "macra/ListOf3BlockRecipe.ftlh" as macro>

<div class="col-8">

    <div>
    <#if recipesForDefaultCategory??>
        <h3 style="text-align: center">IT'S TIME FOR ${defaultCategory}!</h3>
        <@macro.listOf3BlockRecipe list = recipesForDefaultCategory/>
        <div class="justify-content-center search" style="text-align: center;">
            <form action="/search-recipe?fridge" method="get">
                <div class="form-group">
                    <label>Type in what you have in your kitchen and we will find a recipe for you:</label>
                    <input type="text" name="fridge" class="form-control">
                </div>
                <button type="submit" class="btn btn-secondary" style="color: white;background-color: darkorange" >Search</button>
            </form>
        </div>
    <#else>
        <div class="alert alert-danger" role="alert">
            There are no recipes, please load correct JSON file <a href="/upload">Here</a>
        </div>
    </#if>
    </div>

    <div>
        <#if favouriteList??>
            <h3 style="text-align: center">TOP 3!</h3>
            <@macro.listOf3BlockRecipe list = favouriteList/>
        </#if>
    </div>

</div>

<#include "*/common/footer.ftlh">
