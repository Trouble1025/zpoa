// -----------------------------------------------------------加载layui

layui.use(['form', 'layer'], function () {
    form = layui.form;
    layer = layui.layer;

    form.on('select(deptS)', function (data) {
        //部门选择改变事件
        deptId = data.value;
        deptName = $('select[name=dept]').find('option:selected').text();
        $.ajax({
            url: "/dept/allPostByDeptId",
            type: "post",
            data: {"id": deptId},
            success: function (data) {
                reloadPost(data);
            }
        });
    });

});
// -----------------------------------------------------------部门岗位
var form;
var layer;
var deptId;
var deptName;
var postId;
var postName;

$(function () {
    $('#updDeptName').click(function () {
        //更改部门名称按钮
        deptId = $('select[name=dept]').find('option:selected').val();
        deptName = $('select[name=dept]').find('option:selected').text();
        if (deptId == 0 || deptId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="newDeptName" value="' + deptName + '"/><input type="hidden" id="deptId" value="' + deptId + '"/>', {
            btn: ['保存', '取消'],
            title: "修改部门名称"
        }, function (index) {
            var newDeptName = $('#newDeptName').val().trim();
            if (newDeptName != null && newDeptName != "" && newDeptName.length > 0) {
                $.ajax({
                    url: "/dept/updDeptName",
                    type: "post",
                    data: {"deptId": $('#deptId').val(), "newDeptName": newDeptName},
                    success: function (data) {
                        reloadDept(data);
                    }
                })
            }
        });
    });

    $('#addNewDept').click(function () {
        //新增部门按钮
        layer.confirm('<input type="text" class="layui-input" id="addDeptName"/>', {
            btn: ['添加', '取消'],
            title: "新增部门名称"
        }, function (index) {
            var addDeptName = $('#addDeptName').val().trim();
            if (addDeptName != null && addDeptName != "" && addDeptName.length > 0) {
                $.ajax({
                    url: "/dept/addNewDept",
                    type: "post",
                    data: {"addDeptName": addDeptName},
                    success: function (data) {
                        reloadDept(data);
                    }
                });
            }
        });
    });

    $('#updPostName').click(function () {
        //更改岗位名称按钮
        postId = $('select[name=post]').find('option:selected').val()
        postName = $('select[name=post]').find('option:selected').text();
        if (postId == 0 || postId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="newPostName" value="' + postName + '"/>', {
            btn: ['保存', '取消'],
            title: "修改岗位名称"
        }, function (index) {
            var newPostName = $('#newPostName').val();
            if (newPostName != null && newPostName != "" && newPostName.length > 0) {
                $.ajax({
                    url: "/dept/updPostName",
                    type: "post",
                    data: {"newPostName": newPostName,"postId":postId,"deptId":deptId},
                    success: function (data) {
                        reloadPost(data);
                    }
                });
            }
        });
    });

    $('#addNewPost').click(function () {
        if (deptId == 0 || deptId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="addPostName"/>', {
            btn: ['添加', '取消'],
            title: "新增岗位名称"
        }, function (index) {
            var addPostName = $('#addPostName').val().trim();
            if (addPostName != null && addPostName != "" && addPostName.length > 0) {
                $.ajax({
                    url: "/dept/addNewPost",
                    type: "post",
                    data: {"addPostName": addPostName,"deptId":deptId},
                    success: function (data) {
                        reloadPost(data);
                    }
                });
            }
        });
    });

});

function reloadDept(data) {
    //重新加载选择部门的下拉框
    var json = JSON.parse(data);
    $('select[name=dept]').html();
    var deptHtml = '';
    $.each(json, function (i, d) {
        deptHtml += '<option value="' + d.oa_department_id + '">' + d.oa_department_name + '</option>';
    });
    $('select[name=dept]').html(deptHtml);
    $('select[name=dept]').val(deptId);
    deptName = $('select[name=dept]').find('option:selected').text();
    form.render();
    layer.closeAll();
}

function reloadPost(data) {
    //重新加载选择岗位的下拉框
    var json = JSON.parse(data);
    $('select[name=post]').html();
    var postHtml = '';
    $.each(json, function (i, d) {
        postHtml += '<option value="' + d.oa_post_id + '">' + d.oa_post_name + '</option>';
    });
    $('select[name=post]').html(postHtml);
    $('select[name=post]').val(postId);
    postName = $('select[name=post]').find('option:selected').text();
    form.render();
    layer.closeAll();
}

// -----------------------------------------------------------角色