<#include "*/common/header.ftlh">
<h1>Please upload JSON file to create your database</h1>
<form method="post" action="/upload-file" enctype="multipart/form-data">
    <input name="json" type="file" accept=".json" required/><br/><br/>
    <input type="submit" name="save" value="Forward"/><br/><br/>
</form>
<#include "*/common/footer.ftlh">
