<#include "*/common/header.html">

<div>
    <h1>Your Shopping List:</h1>
    <#if shoppingList??>
        <ul>
            <#list shoppingList as ingredient>
                <li>${ingredient.name} ${ingredient.amount} ${ingredient.unit.description}</li>
            </#list>
        </ul>
    <#else>
        <span>Your shopping list is empty</span><br/><br/>
    </#if>
</div>

<#include "*/common/footer.html">