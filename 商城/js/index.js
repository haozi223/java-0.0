(function () {
    var thistime = document.getElementById('time');
    var tutu = document.getElementById('tutu');
    var yingying = document.getElementById('yingyong').children;
    var lunhuanshu = 1;
    var lunhuanqi;
    document.getElementById('soclick').onclick = function () {
        alert('搜索的内容是：' + document.getElementById('content').value)
    }
    function jialing (a) {
        if (a < 10) a = "0" + a;
        return a
    }
    function showTime () {
        var date = new Date();
        thistime.innerHTML = date.getFullYear() + "-" + jialing(date.getMonth() + 1) + "-" + jialing(date.getDate()) + "  " + jialing(date.getHours()) + " : " + jialing(date.getMinutes()) + " : " + jialing(date.getSeconds());
    }
    function biantu () {
        tutu.setAttribute('src', `img/ad-0${lunhuanshu}.jpg`);
        for (var a of yingying) {
            a.classList.remove('huang');
        }
        yingying[lunhuanshu - 1].classList.add('huang');

    }
    for (var xuanfu of yingying) {
        xuanfu.onmouseenter = function () {
            clearInterval(lunhuanqi);
            lunhuanshu = this.innerText * 1;
            biantu();
        }
        xuanfu.onmouseleave = function () {
            lunhuanqi = setInterval(function () {
                if (lunhuanshu >= yingying.length) {
                    lunhuanshu = 1;
                } else {
                    lunhuanshu++
                }
                biantu();
            }, 3000);
        }
    }
    window.onload = function () {
        showTime()
        setInterval(showTime, 1000);
        lunhuanqi = setInterval(function () {
            if (lunhuanshu >= yingying.length) {
                lunhuanshu = 1;
            } else {
                lunhuanshu++
            }
            biantu();
        }, 3000)
    }
}())

