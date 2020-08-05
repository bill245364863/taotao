<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/3/31
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="js/layui-v2.5.6/layui/css/layui.css">

</head>
<body>
<%--<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
    <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
    <button class="layui-btn" data-type="isAll">验证是否全选</button>
</div>

<table class="layui-table" lay-data="{width: 892, height:330, url:'/demo/table/user/', page:true, id:'idTest'}" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
        <th lay-data="{field: 'username', width:100}">用户名</th>
        <th lay-data="{field: 'phone',  width:150}">注册手机号</th>
        <th lay-data="{field: 'email', title: '注册邮箱', width: 150}">注册邮箱</th>

    </tr>
    </thead>
</table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>--%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">批量审批</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">查看单据</button>
        <%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        <button class="layui-btn layui-btn-sm" lay-event="reload">重载</button>--%>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="add">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>



    搜索：
    <div class="layui-inline">
        <input class="layui-input" name="username" id="username" autocomplete="off" placeholder="请输入要搜索的内容">
    </div>
    <button class="layui-btn"  id="search" data-type="reload">搜索</button>

<%--方法渲染--%>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/layui-v2.5.6/layui/layui.js"></script>
<%--<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>--%>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#test'
            ,height: 380
            ,title:"综合待办数据"
            ,url: '/demo/table/user' //数据接口
            ,skin: 'row' //表格风格
            ,page: true
            ,toolbar: '#toolbarDemo'
            ,loading:true
            ,defaultToolbar: ['filter', 'exports', 'print', {
                title: '帮助'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[ //表头
                {type:'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'ID', width:80, hide: true, fixed: 'left'}
                ,{field: 'username', title: '用户名', width:100}
                ,{field: 'password', title: '密码，加密存储', width:350,toolbar:'#barDemo'}
                ,{field: 'phone', title: '注册手机号', width:150,align:'center'}
                ,{field: 'email', title: '注册邮箱', width: 150}
                ,{field: 'created', title: '创建时间', width: 150}
                ,{field: 'updated', title: '修改时间', width: 150}

            ]]


        });



        //监听行工具事件
        table.on('tool(test)',function (obj) {
            //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data,
                layEvent = obj.event; //获得当前行数据
            switch (layEvent) {
                case 'add':
                    layer.msg('添加');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;

            }

        });
        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){

                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
                case 'LAYTABLE_TIPS':
                    layer.alert('Table for layui-v'+ layui.v);
                    break;

            };
        });

       /* $('#search').on('click',function () {
                var username =  $('#username').val();
                //执行重载
                table.reload('test',{
                    url:'/demo/select'
                    ,where:{
                        key: {
                            username: username
                        }
                    }
                    ,page: {
                        curr: 1 //重新从第 1 页开始
                    }
            });
        });*/
        var $ = layui.$, active = {
            reload: function(){
                var username = $('#username');

                //执行重载
                table.reload('test', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            username: username.val()
                        }
                    }
                }, 'data');
            }
        };

        $('.layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });



    });
</script>
</body>
</html>
