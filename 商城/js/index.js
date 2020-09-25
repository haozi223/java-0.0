(function () {
    document.getElementById('soclick').onclick = function () {
        alert('搜索的内容是：' + document.getElementById('content').value)
    }
    function showTime () {
        var date = new Date();
        var y = date.getFullYear()
        var m = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours()
        var min = date.getMinutes()
        if (min < 10) min = "0" + min;
        var s = date.getSeconds();
        if (s < 10) s = "0" + s;
        document.getElementById('time').innerHTML = y + "-" + m + "-" + d + "  " + h + " : " + min + " : " + s;
    }
    window.onload = function () {
        showTime()
        setInterval(showTime, 1000);
    }
}())

