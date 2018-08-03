<#include "*/common/header.ftlh">
<#import "macra/ListOfBlockShoppingList.ftlh" as macro2>

<div class="col-8">
    <#if logged??>
        <#if message??>
            <div class="alert alert-success" role="alert">
                ${message}
            </div>
        </#if>
        <#if shoppingList??>
            <h1 class="text-center">Your Shopping List:</h1>
            <div class="row">
                <div class="col">
                    <h2>What to buy:</h2>

                    <ul class="list-group list-group-flush">
                        <#list shoppingList as ingredient>
                            <li class="list-group-item">${ingredient.name} - ${ingredient.amount} ${ingredient.unit.description}</li>
                        </#list>
                    </ul>
                </div>
                <div class="col">
                    <form method="post" action="/mail" style="margin: 100px">
                        <button style="background-color:darkorange" class="btn btn-secondary">Send list on your e-mail</button>
                    </form>
                </div>
            </div>
        <#else>
            <div class="alert alert-info" role="alert">
                Your shopping list is empty
            </div>
        </#if>

        <#if recipesInShoppingList??>
            <h2 class="text-center">All recipes:</h2>
            <@macro2.listBlockRecipeSL list = recipesInShoppingList/>
        </#if>
    <#else>
        <div class="alert alert-info" role="alert">
            You need to login to use shopping list!
        </div>
    </#if>
</div>

<#include "*/common/footer.ftlh">
