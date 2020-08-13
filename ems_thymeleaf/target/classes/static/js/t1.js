function f() {
    // document.getElementById('num').src = '/ems/code?' + (new Date()).getTime()
    $("#num").attr('src', '/ems/code?' + (new Date()).getTime())
}

function f1() {
    let id = $('input[name="id"]').val()
    let name = $('input[name="name"]').val()
    //空
    if (id == "" || name == ""){
        alert("ID 或 用户名 未输入 ❌")
        return
    }

    $.ajax({
        url: "aUser",
        success: function (result) {
            //ID、用户名
            for (let i = 0; i < result.length; i++) {
                if (id == result[i].id || name == result[i].name) {
                    alert("ID 或 用户名 已存在 ❌")
                    return
                }
            }
            //密码
            let p = $('input[name="pass"]').val()
            let a = $('#again').val()
            if (p != a || p == "" || a == "") {
                alert("密码不一致 或 未输入 ❌")
                return
            }
            //验证码
            code()
        }
    })
}

function code(){
    let e = $("#code").val()
    $.ajax({
        url: "aCode",
        success: function (result) {
            if (e == result) {
                $("#fo").submit()
                alert("注册成功 ✔ ")
            } else {
                $("#code").val("")
                alert("验证码不对 或 未输入 ❌ ")
                f()
            }
        }
    })
}

$(document).ready(function () {
    $("#code").keydown(function (e) {
        // let curKey = e.which;
        if (e.keyCode == 13) {
            f1()
        }
    });
});