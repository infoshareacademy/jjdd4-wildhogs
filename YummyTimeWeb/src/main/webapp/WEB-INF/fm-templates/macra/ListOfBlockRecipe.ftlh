<#macro listBlockRecipe list>
    <div>
    <div class="row">
            <#list list as recipe>
                <div class="card" style="width: 18rem;">
                    <a href="view-recipe?id=${recipe.id}">
                        <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                        <div class="card-body">
                            <h5 class="card-title">${recipe.name}</h5>
                        </div>
                    </a>
                </div>
                <#if (recipe?index + 1) % 3 == 0>
                    </div>
                    <div class="row">
                </#if>
            </#list>
    </div>
    </div>
</#macro>