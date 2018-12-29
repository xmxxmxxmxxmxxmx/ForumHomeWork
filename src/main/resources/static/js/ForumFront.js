
    $('.loginButton').click(function() {
        var phone = $('#phone').val();
        var password = $('#password').val();
        $.getJSON('../usercontroller/login', {
            "phone" : phone,
            "password" : password
        }, function(data) {
            if(data===0){
                alert("请将登录信息填写完整！")
            }else if(data===1){
                console.log("123");
                location.href="../messagecontroller/querymessage"
            }else if(data===2){
                alert("登录密码有误！")
            }else if(data===3){
                alert("登录账号有误！")
            }
            else if(data===4){
                var loginbtn=document.getElementById("login");
                var countdown = 120;
                function settime(obj) {
                    if (countdown == 0) {
                        obj.disabled = false;
                        obj.innerHTML = "登录";
                        countdown = 120;
                        loginbtn.style.background = '#5cb85c';
                        return;
                    } else {
                        obj.disabled = true;
                        obj.innerHTML = "重新发送(" + countdown + "s)";
                        countdown--;
                        loginbtn.style.background = '#999';
                    }
                    setTimeout(function() {
                        settime(obj);
                    }, 1000)
                }
                settime(loginbtn);
                alert("您登陆出错已达到3次，请在2分钟后重新进行登陆操作！");
            }
        })
    })






function savemessage(){
    var messagetitle=$('#messagetitle').val();
    var messagedetail=$('#messagedetail').val();
    var phone=$('#loginphone').val();
    var myFile=$('#myFile').val();
    console.log(phone)
    $.getJSON("../messagecontroller/addmessage",{"messagetitle":messagetitle,"messagedetail":messagedetail,"phone":phone,"myFile":myFile},function(data){
        if(data===0){
            location.href="../messagecontroller/querymessage";
        }
    })
}
