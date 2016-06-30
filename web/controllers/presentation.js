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
            var commentsWrapper = $('#comments');
            data.forEach(function (currentComment, index) {
                commentsWrapper.prepend("<div class=\"comments-wrapper\"><div class=\"commenter\">"+ currentComment.fn +"</div> <div class=\"comment\">"+ currentComment.comment +"</div> </div>");
            })
        }
    });
    $('#login-button').click(function () {
        var fn = localStorage.getItem("fn");
        var comment = $('#login-name');
        comment = comment.val();
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
