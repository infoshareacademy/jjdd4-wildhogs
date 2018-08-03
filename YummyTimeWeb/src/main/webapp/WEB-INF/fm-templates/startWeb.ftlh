<#include "*/common/header.ftlh">
<#import "macra/ListOf3BlockRecipe.ftlh" as macro>

<div class="col-8">

    <div>
    <#if recipesForDefaultCategory??>
        <h3 style="text-align: center">THERE IS TIME FOR ${defaultCategory}!</h3>
        <@macro.listOf3BlockRecipe list = recipesForDefaultCategory/>
        <div class="justify-content-center">
            <form action="/search-recipe?fridge" method="get">
                <div class="form-group">
                    <label>Put what you have got in your fridge, and we will find recipe for You</label>
                    <input type="text" name="fridge" class="form-control">
                </div>
                <button type="submit" class="btn btn-secondary">Search</button>
            </form>
        </div>
    <#else>
        <div class="alert alert-danger" role="alert">
            There are no recipes, please load JSON file! <a href="/upload">Here</a>
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
