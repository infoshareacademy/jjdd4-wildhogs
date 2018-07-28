<#macro listOf3BlockRecipe list>
         <div>
             <div class="row">
                <#list list as recipe>
                    <div class="col-md-4">
                        <div class="card" style="width: 25rem;">
                            <a href="view-recipe?id=${recipe.id}">
                                <img class="card-img-top" src="${recipe.pathToPicture}" alt="picture of Your recipe" >
                                <div class="card-body">
                                    <h5 class="card-title">${recipe.name}</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                </#list>
             </div>
        </div>
</#macro>