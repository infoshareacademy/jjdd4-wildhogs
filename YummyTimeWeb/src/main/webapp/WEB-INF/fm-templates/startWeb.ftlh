<#include "*/header.html">

<div>

    <#if errorMessage1??>
            <span>${errorMessage1}</span><br/><br/>
    </#if>

    <#--zawsze tylko 3-->
    <#if timeCategory??>
    <#list timeCategory as recipe>

        <div>
            <a href="view-recipe?name=${recipe.name}">
            <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
            <h1>${recipe.name}</h1>
            </a>
        </div>

    </#list>
    </#if>

    <div>
        <h1>Fridge</h1>
        <textarea rows="1" cols="60"></textarea>
    </div>


    <#if errorMessage2??>
            <span>${errorMessage2}</span><br/><br/>
    </#if>
    <#--zawsze tylko 3-->
    <#if favouriteList??>
        <#list favouriteList as recipe>

        <div>
            <a href="view-recipe?name=${recipe.name}">
                <img src="${recipe.pathToPicture}" alt="picture of Your recipe" height="200">
                <h1>${recipe.name}</h1>
            </a>
        </div>

        </#list>
    </#if>

</div>

<#include "*/footer.html">