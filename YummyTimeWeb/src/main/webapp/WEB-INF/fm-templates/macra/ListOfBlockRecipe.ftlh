<#macro listBlockRecipe list>
<div class="d-flex justify-content-around">
    <div>
        <div class="row">
                <#list list as recipe>
                    <div class="col">
                        <div class="card" style="width: 25rem;">
                            <a href="view-recipe?id=${recipe.id}">
                                <img class="card-img-top" src="${recipe.pathToPicture}" alt="picture of Your recipe">
                                <div class="card-body">
                                    <h5 class="card-title">${recipe.name}</h5>
                                </div>
                            </a>
                        </div>
                    </div>
                    <#if (recipe?index + 1) % 3 == 0>
                        </div>
                        <div class="row">
                    </#if>
                </#list>
        </div>
    </div>
</div>
</#macro>