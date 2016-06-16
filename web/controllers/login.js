/**
 * Created by User on 6/16/2016.
 */
$(document).ready(function () {
    $('#wrong-login').hide();
    $('#login-button').click(function () {
        $.get("rest/users/login", function (data, status) {
            localStorage.setItem('sid',data);
            window.location.replace("index.html");
        })
    })
});