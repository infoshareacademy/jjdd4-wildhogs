<#include "*/common/header.ftlh">

<div>
    <div id="my-logout"></div>

    <script>
        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });

        }
    </script>
    <script>signOut()</script>

    <img src="https://mail.google.com/mail/u/0/?logout&hl=en"/>
    <form action="/logout" method="get"></form>

    <#--response.sendRedirect(${"/logout"})-->
</div>
<#include "*/common/footer.ftlh">

