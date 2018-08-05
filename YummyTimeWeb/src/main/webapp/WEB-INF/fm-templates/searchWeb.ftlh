<#include "*/common/header.ftlh">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>


<div class="col-8" style="text-align: center;">
    <#if categoryParam??>
        <h3>Result of your search by ${categoryParam}:</h3>
    <#else>
        <h3>Result of your search</h3>
    </#if>

    <#if fridgeParam??>
        <div class="justify-content-center search">
            <form action="/search-recipe?fridge" method="get">
                <div class="form-group">
                    <label>Type in what you have in your kitchen and we will find a recipe for you:</label>
                    <input type="text" name="fridge" value="${fridgeParam}" class="form-control">
                </div>
                <button style="color: white;background-color: darkorange" type="submit" class="btn btn-secondary">Search</button>
            </form>
        </div>
    </#if>

    <#if recipesList??>
        <@macro.listBlockRecipe list = recipesList/>
    <#else>
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </#if>
</div>

<#include "*/common/footer.ftlh">