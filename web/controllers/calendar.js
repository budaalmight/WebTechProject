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
        data: JSON.stringify({sid: sid}),
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
                    data: JSON.stringify({sid: sid, presentationDay: id}),
                    dataType: 'json',
                    success: function (presentations, status) {
                        if (presentations.length != 0) {

                            var oldDateObj = new Date(presentationDay.startTime);
                            var newTime = new Date(presentationDay.startTime);
                            var endTime = new Date(presentationDay.endTime);
                            while (endTime.getTime() > oldDateObj.getTime()) {
                                var inserted = false;
                                presentations.forEach(function (presentation, index) {
                                    var presentationDate = new Date(presentation.startTime);
                                    if (newTime.getTime() == presentationDate.getTime()) {
                                        var row = table.insertRow();
                                        var cell = row.insertCell(0);
                                        var monthNames = [
                                            "January", "February", "March",
                                            "April", "May", "June", "July",
                                            "August", "September", "October",
                                            "November", "December"
                                        ];

                                        var date = newTime;
                                        var day = date.getDate();
                                        var monthIndex = date.getMonth();
                                        var year = date.getFullYear();

                                        console.log(day, monthNames[monthIndex], year);
                                        cell.innerHTML = day + "." + monthNames[monthIndex] + "."
                                            + year + " " + newTime.getHours() + ":" + newTime.getMinutes();
                                        var cell2 = row.insertCell(1);
                                        cell2.innerHTML = presentation.fn;
                                        oldDateObj = newTime;
                                        inserted = true;
                                        cell2.className="table-link";
                                        cell2.onclick = function () {
                                            localStorage.setItem("presentation", presentation.id);
                                            window.location.href = "/presentation.html";
                                        }
                                    }
                                });
                                if (!inserted) {
                                    var row = table.insertRow();
                                    var cell = row.insertCell(0);
                                    cell.innerHTML = newTime.getDay() + "." + newTime.getMonth() + "."
                                        + newTime.getFullYear() + " " + newTime.getHours() + ":" + newTime.getMinutes();
                                    var cell2 = row.insertCell(1);
                                    cell2.className="table-link";
                                    cell2.innerHTML = "Free";
                                    oldDateObj = newTime;
                                }
                                newTime = new Date(oldDateObj.getTime() + presentationDay.duration * 60000);
                            }
                        }
                    }
                });
            });
        }
    });
});