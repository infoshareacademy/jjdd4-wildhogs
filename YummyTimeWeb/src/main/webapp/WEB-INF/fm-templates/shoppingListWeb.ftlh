<#include "*/common/header.html">
<#import "macra/ListOfBlockRecipe.ftlh" as macro>
<#import "macra/ListOfBlockShoppingList.ftlh" as macro2>

<div>
    <h1>Your Shopping List:</h1>

    <form method="get" action="/clear-list"><input type=submit value="Clear list" onClick="history.go()"></form>

    <h2>What to buy:</h2>
    <#if shoppingList??>
        <ul>
            <#list shoppingList as ingredient>
                <li>${ingredient.name} ${ingredient.amount} ${ingredient.unit.description}</li>
            </#list>
        </ul>
    <#else>
        <span>Your shopping list is empty</span><br/><br/>
    </#if>

    <#if recipesInShoppingList??>
        <h2>All recipes:</h2>
        <@macro2.listBlockRecipeSL list = recipesInShoppingList/>
    </#if>
</div>

<#include "*/common/footer.html">