<#macro listBlockRecipe list>
    <#list list as recipe>
        <div class="col-3">
            <a href="view-recipe?name=${recipe.name}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>
    </#list>
</#macro>