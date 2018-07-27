<#macro listBlockRecipeSL list>
    <#list list as recipe>
        <div>
            <a href="view-recipe?id=${recipe.id}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
            <form method="post" action="/sub-shoppingList?id=${recipe.id}">
                <input type="button" value="Delete">
            </form>
        </div>
    </#list>
</#macro>