(function () {
    var thistime = document.getElementById('time');
    var tutu = document.getElementById('tutu');
    var tututu = document.getElementById('tututu');
    var yingying = document.getElementById('yingyong').children;
    var zhezhao = document.getElementById('zhezhao');
    var zhezhaoqi;
    var zhezhaoshu = 1;
    var lunhuanshu = 1;
    var lunhuanqi;
    var lunboimg;
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
        clearInterval(zhezhaoqi);
        zhezhao.style.opacity = 1;
        zhezhaoshu = 1;
        tutu.setAttribute('src', `http://localhost:8080/websql${lunboimg[lunhuanshu - 1].img_url}`);
        for (var a of yingying) {
            a.classList.remove('huang');
        }
        yingying[lunhuanshu - 1].classList.add('huang');
        zhezhaoqi = setInterval(function () {
            if (zhezhaoshu <= 0) {
                clearInterval(zhezhaoqi);
            } else {
                zhezhaoshu = (zhezhaoshu - 0.1).toFixed(1);
                zhezhao.style.opacity = zhezhaoshu;
            }
        }, 50)

    }

    function ajax (opt) {
        //默认参数
        let defaultOpt = {
            data: '',
            asyn: true,
            error: null
        }

        //替换
        Object.assign(defaultOpt, opt);//用defaultOpt

        //1.创建对象
        let xhr = new XMLHttpRequest();

        //2.写好参数，准备工作  open()
        if (defaultOpt.type.toLowerCase() == 'get') {
            //get请求
            if (defaultOpt.data) {
                //有数据，把数据拼接在url
                defaultOpt.url = defaultOpt.url + '?' + objToStr(defaultOpt.data);
            }
            xhr.open('get', defaultOpt.url, defaultOpt.asyn);
            xhr.send(null);
        } else {
            //post请求
            xhr.open('post', defaultOpt.url, defaultOpt.asyn);
            let data = objToStr(defaultOpt.data);
            xhr.setRequestHeader('content-type', "application/x-www-form-urlencoded");//请求头
            xhr.send(data);
        }

        //4.接收数据
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    //成功  
                    defaultOpt.success(xhr.responseText);//实参
                } else {
                    //失败
                    if (defaultOpt.error) {
                        defaultOpt.error(xhr.status);//实参：http状态码
                    }
                }
            }
        }

    }
    window.onload = function () {
        showTime()
        setInterval(showTime, 1000);
        ajax({
            type: 'get', url: 'http://localhost:8080/websql/imgget', success (a) {
                lunboimg = JSON.parse(a);
                lunhuanqi = setInterval(function () {
                    if (lunhuanshu >= yingying.length) {
                        lunhuanshu = 1;
                    } else {
                        lunhuanshu++
                    }
                    biantu();
                }, 3000)
                tututu.onmouseenter = function () {
                    clearInterval(lunhuanqi);
                }
                tututu.onmouseleave = function () {
                    lunhuanqi = setInterval(function () {
                        if (lunhuanshu >= yingying.length) {
                            lunhuanshu = 1;
                        } else {
                            lunhuanshu++
                        }
                        biantu();
                    }, 3000);
                }
                for (var xuanfu of yingying) {
                    xuanfu.onmouseenter = function () {
                        lunhuanshu = this.innerText * 1;
                        biantu();
                    }
                }
            }
        })
    }
}())

