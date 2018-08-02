<#include "*/common/header.ftlh">
<#import "macra/ListOfBlockShoppingList.ftlh" as macro2>
<div class="col-8">
<div>

    <#if shoppingList??>
        <h1 class="text-center">Your Shopping List:</h1>

        <h2>What to buy:</h2>

        <ul class="list-group list-group-flush">
            <#list shoppingList as ingredient>
                <li class="list-group-item">${ingredient.name} - ${ingredient.amount} ${ingredient.unit.description}</li>
            </#list>
        </ul>
    <#else>
        <div class="alert alert-info" role="alert">
            Your shopping list is empty
        </div>
    </#if>

    <#if recipesInShoppingList??>
        <h2 class="text-center">All recipes:</h2>
        <@macro2.listBlockRecipeSL list = recipesInShoppingList/>
    </#if>
</div>
</div>
<#include "*/common/footer.ftlh">