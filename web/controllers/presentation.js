$(document).ready(function () {
    var sid = localStorage.getItem("sid");
    var presentation = localStorage.getItem("presentation");
    jQuery.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': "/rest/comments/getAll",
        'data': JSON.stringify({sid:sid,presentation:presentation}),
        'dataType': 'json',
        'success': function (data, status) {
            var commentsWrapper = document.getElementById("comments");
            data.forEach(function (currentComment, index) {
                commentsWrapper.prepend("<div class=\"comments-wrapper\"><div class=\"commenter\">"+ currentComment.fn +"</div> <div class=\"comment\">"+ currentComment.comment +"</div> </div>");
            })
        }
    });
    var comment = document.getElementById("login-name");
    comment = comment.val();
    $('#login-button').click(function () {
        var fn = localStorage.getItem("fn");
        fn = fn.val();
        jQuery.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': "/rest/comments/create",
            'data': JSON.stringify({sid:sid,comment:comment,presentation:presentation,fn:fn}),
            'dataType': 'json',
            'success': function (data, status) {
                location.reload();
            }
        });
    });
});
