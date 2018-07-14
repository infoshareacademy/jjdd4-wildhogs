<div>

    <#if errorMessage??>
        <span>${errorMessage}</span><br/><br/>
    </#if>

    <#if recipe??>
        <h1>${recipe.name}</h1>
        <p>${recipe.category}</p>
        <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="500">
        <#list recipe.ingredientsMap as key, value>

            <ul>
                <li>${key} ${value.amount} ${value.unit.description}</li>
            </ul>
        </#list>

        <p>${recipe.description}</p>
    </#if>
    <button>Add to shopping list!</button>
    <button>Add to favorite!</button>
</div>