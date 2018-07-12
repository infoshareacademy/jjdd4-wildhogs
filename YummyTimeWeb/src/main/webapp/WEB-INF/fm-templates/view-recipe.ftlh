<div>#include"/header.html"</div>

<div>

    <#if errorMessage??>
        <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    </#if>

    <#--<#if recipe??>-->
        <h1>${name}</h1>
        <p>${category}</p>

        <#--<#list recipe.ingredientsMap>-->
        <#---->
           <#---->
        <#--<li></li>-->
        <#--<p>${user.id}, ${user.name}, ${user.login}, ${user.age}, ${user.gender}, ${pulse}</p>-->
        <#--</#list>-->
        <p>${description}</p>

    <#--</#if>-->

</div>

<div>#include"/footer.html"</div>