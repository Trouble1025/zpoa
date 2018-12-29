var form;
var layer;
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

var deptId;
var deptName;
var postId;
var postName;
var roleId;
var roleName;
var staffStateId;
var staffStateName;
var powerId;
var powerName;

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
        //新增岗位名称
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

    $('#updRoleName').click(function () {
        //更改角色名称按钮
        roleId = $('select[name=role]').find('option:selected').val();
        roleName = $('select[name=role]').find('option:selected').text();
        if (roleId == 0 || roleId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="newRoleName" value="' + roleName + '"/><input type="hidden" id="roleId" value="' + roleId + '"/>', {
            btn: ['保存', '取消'],
            title: "修改角色名称"
        }, function (index) {
            var newRoleName = $('#newRoleName').val().trim();
            if (newRoleName != null && newRoleName != "" && newRoleName.length > 0) {
                $.ajax({
                    url: "/super/updRoleName",
                    type: "post",
                    data: {"roleId": $('#roleId').val(), "newRoleName": newRoleName},
                    success: function (data) {
                        reloadRole(data);
                    }
                });
            }
        });
    });

    $('#addNewRole').click(function () {
        //新增角色
        layer.confirm('<input type="text" class="layui-input" id="addRoleName"/>', {
            btn: ['添加', '取消'],
            title: "新增角色名称"
        }, function (index) {
            var addRoleName = $('#addRoleName').val().trim();
            if (addRoleName != null && addRoleName != "" && addRoleName.length > 0) {
                $.ajax({
                    url: "/super/addRoleName",
                    type: "post",
                    data: {"roleName": addRoleName},
                    success: function (data) {
                        reloadRole(data);
                    }
                });
            }
        });
    });

    $('#updStaffState').click(function () {
        //更改状态名称按钮
        staffStateId = $('select[name=staffState]').find('option:selected').val();
        staffStateName = $('select[name=staffState]').find('option:selected').text();
        if (staffStateId == 0 || staffStateId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="newStateName" value="' + staffStateName + '"/><input type="hidden" id="staffStateId" value="' + staffStateId + '"/>', {
            btn: ['保存', '取消'],
            title: "修改角色名称"
        }, function (index) {
            var newStateName = $('#newStateName').val().trim();
            if (newStateName != null && newStateName != "" && newStateName.length > 0) {
                $.ajax({
                    url: "/super/updStaffStateName",
                    type: "post",
                    data: {"staffStateId": $('#staffStateId').val(), "newStateName": newStateName},
                    success: function (data) {
                        reloadStaffState(data);
                    }
                });
            }
        });
    });

    $('#addNewStaffState').click(function () {
        //新增员工状态
        layer.confirm('<input type="text" class="layui-input" id="addStaffStateName"/>', {
            btn: ['添加', '取消'],
            title: "新增状态名称"
        }, function (index) {
            var addStaffStateName = $('#addStaffStateName').val().trim();
            if (addStaffStateName != null && addStaffStateName != "" && addStaffStateName.length > 0) {
                $.ajax({
                    url: "/super/addStaffStateName",
                    type: "post",
                    data: {"stateName": addStaffStateName},
                    success: function (data) {
                        reloadStaffState(data);
                    }
                });
            }
        });
    });

    $('#updPowerName').click(function () {
        //更改状态名称按钮
        powerId = $('select[name=power]').find('option:selected').val();
        powerName = $('select[name=power]').find('option:selected').text();
        if (powerId == 0 || powerId == undefined)
            return
        layer.confirm('<input type="text" class="layui-input" id="newPowerName" value="' + powerName + '"/><input type="hidden" id="powerId" value="' + powerId + '"/>', {
            btn: ['保存', '取消'],
            title: "修改角色名称"
        }, function (index) {
            var newPowerName = $('#newPowerName').val().trim();
            if (newPowerName != null && newPowerName != "" && newPowerName.length > 0) {
                $.ajax({
                    url: "/super/updPowerName",
                    type: "post",
                    data: {"powerId": $('#powerId').val(), "newPowerName": newPowerName},
                    success: function (data) {
                        reloadPower(data);
                    }
                });
            }
        });
    });

    $('#addNewPower').click(function () {
        //新增操作权限
        layer.confirm('<input type="text" class="layui-input" id="addPowerName"/>', {
            btn: ['添加', '取消'],
            title: "新增状态名称"
        }, function (index) {
            var addPowerName = $('#addPowerName').val().trim();
            if (addPowerName != null && addPowerName != "" && addPowerName.length > 0) {
                $.ajax({
                    url: "/super/addPowerName",
                    type: "post",
                    data: {"powerName": addPowerName},
                    success: function (data) {
                        reloadPower(data);
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

function reloadRole(data) {
    //重新加载选择角色的下拉框
    var json = JSON.parse(data);
    $('select[name=role]').html();
    var roleHtml = '';
    $.each(json, function (i, d) {
        roleHtml += '<option value="' + d.oa_role_id + '">' + d.oa_role_name + '</option>';
    });
    $('select[name=role]').html(roleHtml);
    $('select[name=role]').val(roleId);
    roleName = $('select[name=role]').find('option:selected').text();
    form.render();
    layer.closeAll();
}

function reloadStaffState(data) {
    //重新加载选择角色的下拉框
    var json = JSON.parse(data);
    $('select[name=staffState]').html();
    var staffStateHtml = '';
    $.each(json, function (i, d) {
        staffStateHtml += '<option value="' + d.oa_staffState_id + '">' + d.oa_staffState_name + '</option>';
    });
    $('select[name=staffState]').html(staffStateHtml);
    $('select[name=staffState]').val(staffStateId);
    staffStateName = $('select[name=staffState]').find('option:selected').text();
    form.render();
    layer.closeAll();
}

function reloadPower(data) {
    //重新加载权限
    var json = JSON.parse(data);
    $('select[name=power]').html();
    var powerhtml = '';
    $.each(json, function (i, d) {
        powerhtml += '<option value="' + d.oa_power_id + '">' + d.oa_power_name + '</option>';
    });
    $('select[name=power]').html(powerhtml);
    $('select[name=power]').val(powerId);
    powerName = $('select[name=power]').find('option:selected').text();
    form.render();
    layer.closeAll();
}
