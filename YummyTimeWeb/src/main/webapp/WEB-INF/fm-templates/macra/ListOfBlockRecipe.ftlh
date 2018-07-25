<#macro listBlockRecipe list>
    <#list list as recipe>
        <div>
            <a href="view-recipe?name=${recipe.id}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>
    </#list>
</#macro>