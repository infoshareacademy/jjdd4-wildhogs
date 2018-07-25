<#macro listOf3BlockRecipe list>
    <#list list as recipe>
        <div>
            <a href="view-recipe?id=${recipe.id}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>
    </#list>
</#macro>