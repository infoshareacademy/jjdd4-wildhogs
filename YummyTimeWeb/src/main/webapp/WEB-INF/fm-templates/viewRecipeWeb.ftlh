<#include "*/common/header.ftlh">

<div class="col-8">
    <#if message??>
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </#if>
    <#if recipe??>
        <h1 style="text-align: center;">${recipe.name}</h1>
        <h5>CATEGORY: ${recipe.category}</h5>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <img src="${recipe.pathToPicture}" style="margin: 0px auto 20px;" alt="picture of Your recipe" height="500">
                </div>
                <div class="col">
                    <ul class="list-group list-group-flush">
                    <#list recipe.ingredientsList as value>
                        <li class="list-group-item">${value.name} - ${value.amount} ${value.unit.description}</li>
                    </#list>
                    </ul>
                    <div style="margin: 20px">
                        <form method="post" action="/to-shoppingList?id=${recipe.id}">
                            <button class="btn btn-secondary">Add to shopping list!</button>
                        </form> <br><br>

                        <form method="post" action="/to-favorite?id=${recipe.id}">
                            <button class="btn btn-secondary">Like!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <p class="text-justify">${recipe.description}</p>

    <#else>
        <div class="alert alert-danger" role="alert">
            Recipe not found!
        </div>
    </#if>
</div>

<#include "*/common/footer.ftlh">
