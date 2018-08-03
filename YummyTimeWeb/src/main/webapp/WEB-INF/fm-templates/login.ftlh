<#include "*/common/header.ftlh">
<!--TODO RODO STUFF etc So we are cool and dandy - We are collecting your email and name information. Blame RODO-->
<div>

    <div id="my-signin2"></div>

    <script>
        function onSuccess(googleUser) {
            console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
        }

        function onFailure(error) {
            console.log(error);
        }

        function renderButton() {
            gapi.signin2.render('my-signin2', {
                'scope': 'profile email',
                'width': 240,
                'height': 50,
                'longtitle': true,
                'theme': 'dark',
                'onsuccess': onSuccess,
                'onfailure': onFailure
            });
        }
    </script>

    <div style="text-align: center; margin: 0" class="g-signin2" data-onsuccess="onSignIn"></div>

    <script>
        //google callback. This function will redirect to our login servletsDoGET
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('ID: ' + profile.getId());
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail());
            console.log('id_token: ' + googleUser.getAuthResponse().id_token);

            //do not post all above info to the server because that is not secure.
            //just send the id_token

            var redirectUrl = 'login';

            //using jquery to post data dynamically
            var form = $('<form action="' + redirectUrl + '" method="post">' +
                    '<input type="text" name="id_token" value="' +
                    googleUser.getAuthResponse().id_token + '" />' +
                    '</form>');
            $('body').append(form);
            form.submit();
        }

    </script>

</div>
<#include "*/common/footer.ftlh">