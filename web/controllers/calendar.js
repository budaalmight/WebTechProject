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
    $.getJSON(url, {'sid' : sid}, function (data, status) {
        var table = document.getElementById("table-body");
        data.forEach(function (item, index) {
            var id = item.id;
            $.getJSON("/rest/Presentation/getAll", {sid: sid, presentationDay: id}, function (data, status) {
                var oldDateObj = item.startTime;
                var newTime = item.startTime;
                while (item.endTime.getTime() > oldDateObj.getTime()) {
                    newTime = new Date(oldDateObj.getTime() + item.duration * 60000);
                    var inserted = false;
                    data.forEach(function (item, index) {
                        if (newTime.getTime() == item.startTime.getTime()) {
                            var row = table.insertRow();
                            var cell = row.insertCell(0);
                            cell.innerHTML = newTime.toISOString().slice(0, 10).replace(/-/g, "");
                            var cell2 = row.insertCell(1);
                            cell2.innerHTML = item.fn;
                            oldDateObj = newTime;
                            inserted = true;
                            cell2.onclick = function () {
                                localStorage.setItem("presentation", item.id);
                                window.location.href = "/presentation.html";
                            }
                        }
                    });
                    if (inserted) {
                        var row = table.insertRow();
                        var cell = row.insertCell(0);
                        cell.innerHTML = newTime.toISOString().slice(0, 10).replace(/-/g, "");
                        var cell2 = row.insertCell(1);
                        cell2.innerHTML = "Free";
                        oldDateObj = newTime;
                    }
                }
            }).fail(function () {
                console.log(arguments);
            });
        });
    }).fail(function () {
        console.log(arguments);
    });
});