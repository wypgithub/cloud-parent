function loadChildPage(modelId, param) {
    param = param || {}

    $.get('/manager/' + modelId, param, function (data) {
        setHtml(data)
    });
}

function loadUserChildPage(modelId, param) {
    param = param || {}

    $.get('/user/' + modelId, param, function (data) {
        setHtml(data)
    });
}

function setHtml(data) {
    if('notLogin' === data){
        location.href = '/loginPage'
    }else {
        $(".layui-main").html(data)
    }
}