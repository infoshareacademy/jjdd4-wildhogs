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
    </#if>
</div>

<#include "*/common/footer.ftlh">