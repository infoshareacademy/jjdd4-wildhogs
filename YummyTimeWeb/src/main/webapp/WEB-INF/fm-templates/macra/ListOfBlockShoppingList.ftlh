<#macro listBlockRecipeSL list>
    <div>
        <div class="row">
            <#list list as recipe>
                <div class="card" style="width: 18rem;">
                    <a href="view-recipe?id=${recipe.id}">
                        <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                        <h1>${recipe.name}</h1>
                    </a>
                    <form method="post" action="/sub-shoppingList?id=${recipe.id}">
                        <input type="submit" value="Delete">
                    </form>
                </div>
                <#if (recipe?index + 1) % 3 == 0>
                    </div>
                    <div class="row">
                </#if>
            </#list>
        </div>
    </div>
</#macro>