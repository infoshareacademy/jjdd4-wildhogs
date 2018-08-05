<#include "*/common/header.ftlh">
<div class="col-8 text-center">
    <h1>Please upload JSON file to create your database</h1>
    <div style="margin: 30px auto">
        <form method="post" action="/upload-file" enctype="multipart/form-data">
            <div class="form-group">
            <input name="json" type="file" accept=".json" class="form-control-file btn btn-secondary" style="color: white;background-color: darkorange" required/><br/><br/>
            <input type="submit" name="save" value="Forward" class="btn btn-secondary" style="color: white;background-color: darkorange"/><br/><br/>
            </div>
        </form>
    </div>
</div>
<#include "*/common/footer.ftlh">
