<#include "*/common/header.html">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>
<#import "macra/ListOfBlockShoppingList.ftlh" as macro2>
<div style="text-align: center;" class="col-10">
<div>

    <#if shoppingList??>
        <h1>Your Shopping List:</h1>

        <h2>What to buy:</h2>

        <ul>
            <#list shoppingList as ingredient>
                <li>${ingredient.name} ${ingredient.amount} ${ingredient.unit.description}</li>
            </#list>
        </ul>
    <#else>
        <div class="alert alert-info" role="alert">
            Your shopping list is empty
        </div>
    </#if>

    <#if recipesInShoppingList??>
        <h2>All recipes:</h2>
        <@macro2.listBlockRecipeSL list = recipesInShoppingList/>
    </#if>
</div>
</div>
<#include "*/common/footer.html">