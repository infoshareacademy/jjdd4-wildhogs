<#include "*/common/header.html">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>

<div style="text-align: center;" class="col-10">

<div class="container">
<#if recipesList??>
<h1>Result of your search by ${parameter}:</h1>
    <@macro.listBlockRecipe list = recipesList/>
<#else>
    <div class="alert alert-danger" role="alert">
        ${errorMessage}
    </div>
</#if>
</div>
</div>

<#include "*/common/footer.html">