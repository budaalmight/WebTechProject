/**
 * Created by User on 6/16/2016.
 */
$(document).ready(function () {
    $('#wrong-login').hide();
    $('#login-button').click(function () {
        var username = $('#login-fn').getText();
        var password = $('#login-password').getText();
        $.post("rest/users/login",{username: username, password: password} , function (data, status) {
            localStorage.setItem('sid',data);
            window.location.replace("index.html");
        })
    })
});