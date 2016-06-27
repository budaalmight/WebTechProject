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
    $.getJSON = function (url, data, callback) {
        return jQuery.ajax({
            headers:{
              'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'GET',
            'url': url,
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': callback
        });
    };
    $('#wrong-login').hide();
    $('#login-button').click(function () {
        var username = $('#login-name');
        var u = username.val();
        var password = $('#login-pass');
        var p = password.val();
        $.postJSON("/rest/users/login",{username: u, password: p} , function (data, status) {
            localStorage.setItem('sid',data.sid);
            window.location.href ="/Calendar.html";
        }).fail(function () {
            console.log(arguments);
            $('#wrong-login').show();
        })
    })
});