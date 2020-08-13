$(document).ready(function () {
    $("#password").keydown(function (e) {
        // let curKey = e.which;
        if (e.keyCode == 13) {
            f1()
        }
    })
    $('input[name="name"]').keydown(function (e) {
        if (e.keyCode == 13) {
            $("#password").focus()
        }
    })
})

function f1() {
    let name = $('input[name="name"]').val()
    let password = $('#password').val()

    //空
    if (name == "" || password == ""){
        alert("用户名 或 密码 未输入 ❌")
        return
    }else {
        $.ajax({
            url: "aUser",
            success: function (result) {
                //ID、用户名
                for (let i = 0; i < result.length; i++) {
                    if (name == result[i].name && password == result[i].pass) {
                        // alert("登陆成功 ✔")
                        $("#lg").submit()
                        return
                    }
                }
                alert("用户不存在 或 密码 ❌")
            }
        })
    }
}
