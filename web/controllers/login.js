$(document).ready(function () {
    $.postJSON = function(url, data, callback) {
        return jQuery.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': url,
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': callback
        });
    };
    $('#wrong-login').hide();
    $('#login-button').click(function () {
        var username = $('#login-fn');
        var u = username.val();
        var password = $('#login-password');
        var p = password.val();
        $.postJSON("/rest/users/login",{username: u, password: p} , function (data, status) {
            localStorage.setItem('sid',data.sid);
            window.location.href ="/index.html";
        }).fail(function () {
            console.log(arguments);
            $('#wrong-login').show();
        })
    })
});