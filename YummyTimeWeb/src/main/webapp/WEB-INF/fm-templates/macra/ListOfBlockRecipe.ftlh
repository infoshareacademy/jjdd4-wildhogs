<#macro listBlockRecipe list>
    <#list list as recipe>
        <div class="card" style="width: 18rem;">
            <a href="view-recipe?id=${recipe.id}">
                    <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                    <div class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                    </div>
              </a>
        </div>
    </#list>
</#macro>

