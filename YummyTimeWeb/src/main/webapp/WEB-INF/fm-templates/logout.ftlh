<#include "*/common/header.ftlh">

<div>
    <div></div>

    <script>
        function signOut() {
            // var auth2 = gapi.auth2.getAuthInstance();
            // auth2.signOut().then(function () {
            //     console.log('User signed out.');
                window.location.href = "/welcome";
            // });
        }
    </script>

    <script type="text/javascript"
            src="https://mail.google.com/mail/u/0/?logout&hl=en" />
    <script>signOut()</script>


<#--<form action="/logout" method="get"></form>-->

    <#--response.sendRedirect(${"/logout"})-->
</div>
<#include "*/common/footer.ftlh">

