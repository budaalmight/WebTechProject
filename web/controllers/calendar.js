$.getJSON = function (url, data, callback) {
    return jQuery.ajax({
        headers: {
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
$(document).ready(function () {
    var url = "/rest/PresentationDay/getAll";
    var sid = localStorage.getItem("sid");
    if (sid == null) {
        window.location.href = "/login.html";
    }
    $.getJSON(url, sid, function (data, status) {
        var table = document.getElementById("table-body");
        data.forEach(function (item, index) {
            var oldDateObj = item.startTime;
            while (item.endTime.getTime() > newTime) {
                var newTime = new Date(oldDateObj.getTime() + item.duration * 60000);
                var row = table.insertRow();
                var cell = row.insertCell(0);
                cell.innerHTML = newTime.toISOString().slice(0,10).replace(/-/g,"");
            }
        });
    });
});