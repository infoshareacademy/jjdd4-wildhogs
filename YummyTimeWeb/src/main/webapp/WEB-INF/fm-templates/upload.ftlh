<#include "*/common/header.ftlh">
<div class="col-8">
    <h1>Please upload JSON file to create your database</h1>
    <div style="margin: 30px auto">
        <form method="post" action="/upload-file" enctype="multipart/form-data">
            <input name="json" type="file" accept=".json" required/><br/><br/>
            <input type="submit" name="save" value="Forward"/><br/><br/>
        </form>
    </div>
</div>
<#include "*/common/footer.ftlh">
