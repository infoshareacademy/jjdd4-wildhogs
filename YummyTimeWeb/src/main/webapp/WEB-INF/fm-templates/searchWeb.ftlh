<#include "*/common/header.html">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>
<div style="text-align: center;">

<div>
<#if recipesList??>
<h1>Result of your search by ${parameter}:</h1>
    <@macro.listBlockRecipe list = recipesList/>
<#else>
    <span>${errorMessage}</span><br/><br/>
</#if>
</div>

<#include "*/common/footer.html">