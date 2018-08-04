<#include "*/common/header.ftlh">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>


<div class="col-8" style="text-align: center;">
    <#if recipesList??>
    <h1>Result of your search by ${parameter}:</h1>
        <@macro.listBlockRecipe list = recipesList/>
    <#else>
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
        <#if tryAgain??>
            <h3 style="text-align: center">TRY AGAIN!</h3>
            <div class="justify-content-center">
                <form action="/search-recipe?fridge" method="get">
                    <div class="form-group">
                        <label>Type in what you have in your kitchen and we will find a recipe for you:</label>
                        <input type="text" name="fridge" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-secondary">Search</button>
                </form>
            </div>
        </#if>
    </#if>
</div>

<#include "*/common/footer.ftlh">