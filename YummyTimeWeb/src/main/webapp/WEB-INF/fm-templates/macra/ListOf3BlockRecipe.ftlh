<#macro listOf3BlockRecipe list>
    <div>
         <div class="row">
            <#list list as recipe>
                <div class="col card" style="width: 10rem;">
                    <a href="view-recipe?id=${recipe.id}">
                        <img class="card-img-top" src="${recipe.pathToPicture}" alt="picture of Your recipe" >
                        <div class="card-body">
                            <h5 class="card-title">${recipe.name}</h5>
                        </div>
                    </a>
                </div>
            </#list>
        </div>
    </div>
</#macro>