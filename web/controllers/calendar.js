$(document).ready(function () {
    var url = "/rest/PresentationDay/getAll";
    var sid = localStorage.getItem("sid");
    if (sid == null) {
        window.location.href = "/login.html";
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: url,
        data: JSON.stringify({sid:sid}),
        dataType: 'json',
        success: function (presentationdays, status) {
            var table = document.getElementById("table-body");
            presentationdays.forEach(function (presentationDay, index) {
                var id = presentationDay.id;
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: 'POST',
                    url: "/rest/Presentation/getAll",
                    data: JSON.stringify({sid:sid,presentationDay:id}),
                    dataType: 'json',
                    success: function (presentations, status) {
                        var oldDateObj = new Date(presentationDay.startTime);
                        var newTime = new Date(presentationDay.startTime);
                        var endTime = new Date(presentationDay.endTime);
                        while (endTime.getTime() > oldDateObj.getTime()) {
                            newTime = new Date(oldDateObj.getTime() + presentationDay.duration * 60000);
                            var inserted = false;
                            presentations.forEach(function (presentation, index) {
                                if (newTime.getTime() == new Date(presentation.startTime).getTime()) {
                                    var row = table.insertRow();
                                    var cell = row.insertCell(0);
                                    cell.innerHTML = newTime.toISOString().slice(0, 10).replace(/-/g, "");
                                    var cell2 = row.insertCell(1);
                                    cell2.innerHTML = presentation.fn;
                                    oldDateObj = newTime;
                                    inserted = true;
                                    cell2.onclick = function () {
                                        localStorage.setItem("presentations", presentation.id);
                                        window.location.href = "/presentations.html";
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
                    }
                });
            });
        }
    });
});