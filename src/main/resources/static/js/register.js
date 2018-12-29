function selectcode(){
    var images=['3n3d.png','7wob.png','dwse.png','m8k2.png'];
    var url=images[Math.floor(Math.random()*images.length)];
    document.getElementById('i').src="../picture/"+url;
    console.log(url);
}


$('#phone').on('blur',function () {
    var newphone = $('#phone').val();
    if (!(/^1[34578]\d{9}$/.test(newphone))) {

    } else {
        $.getJSON('../usercontroller/ifexist', {
            "phone" : newphone
        }, function(data) {
            console.log(data)
            if (data === 0) {
                $('.tip').toggle();
            } else {
                $('.tip').hide();
            }
        })
    }
});



var mfbtn = document.getElementById('rcbtn');
var countdown = 60;
function settime(obj) {
    if (countdown == 0) {
        obj.disabled = false;
        obj.innerHTML = "获取验证码";
        countdown = 60;
        return;
    } else {
        obj.disabled = true;
        obj.innerHTML = "重新发送(" + countdown + "s)";
        countdown--;
        mfbtn.style.background = '#999';
    }
    setTimeout(function() {
        settime(obj);
    }, 1000)
}
mfbtn.onclick=function(){
    $('#showcode').show();
    settime(mfbtn);
    alert("手机验证码已成功发送，请注意查收");
    var newcode = Math.floor(Math.random() * 10000);
    document.getElementById('showcode').innerHTML = newcode;
    var providecode = $('#showcode').html();
    $.getJSON('../usercontroller/sessionexist', {
        "providecode" : providecode
    }, function(data) {
    })
};


    var identifypwcode = document.getElementById('idenitfypwcode');
    identifypwcode.onclick=function(){
        var writepwcode=$('#writepwcode').val();
        var icode = document.getElementById("i").src
        var somecode=icode.substring(39,43);
        console.log(writepwcode+"******"+icode+"^^^^^"+somecode)
        if(writepwcode===somecode){
            $("#showcode").show();
            $(".pwcodeinput").hide();
            $("#exampleInputEmail3").removeAttr("disabled")
        }else{
            alert("输入错误，请重试！");
        }
    }

    function insertuser(){
        console.log("/")
        var newphone = $('#phone').val();
        var newpassword = $('#password').val();
        $.getJSON("../usercontroller/insertuser",{"phone":newphone,"password":newpassword},function(data){
        })
    }


    $('.btn').click(function() {
        var newphone = $('#phone').val();
        var newpassword = $('#password').val();
        var code = $('#exampleInputEmail3').val();
        var providecode = $('#showcode').html();
        var url = '../usercontroller/adduser';
        $.ajax({
            url : url,
            type : 'get',
            dataType : "json",
            data : {
                "phone" : newphone,
                "password" : newpassword,
                "code" : code,
                "providecode" : providecode,
            },
            success : function(data) {
                console.log(data);
                //console.log(data['9']);
                //console.log(data.code);
                if (data === 0) {
                    alert("手机验证码失效，请重新获取！")
                } else if (data === 2) {
                    console.log(newpassword)


                    if(!(/^1[34578]\d{9}$/.test(newphone))){
                        alert("手机号码格式有误！");

                    }else if(newpassword.length < 4){
                        alert("密码不得少于4位！")
                    }else if(frm.checkbox.checked==true){
                        alert("您已经成功注册！")
                        insertuser();
                        window.location.href="../usercontroller/tologin";
                    }else{
                        alert("请阅读并同意相关协议可注册！")
                    }

                }else if (data === 1) {
                    alert("验证码输入错误，请重新输入")
                    $("#showcode").hide();
                    $(".pwcodeinput").show();
                    document.getElementById("exampleInputEmail3").disabled="true"
                }else if (data === 9) {
                    alert("请将各项填写完整！")
                } else if (data === 3) {
                    alert("该手机号已被注册，请前去登陆！")
                }
            }

        })

    })


