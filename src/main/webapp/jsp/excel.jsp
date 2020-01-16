<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/jquery-1.8.0.min.js"></script>
    <script src="../js/pubfun.js"></script>
    <title>JSP Page</title>
</head>
<body>
    <h3>This is JSP Page</h3>
    <div>
        <%--<input type="button" value="导出" onclick="exportExcle();">--%>
        <form action="/oscar/export.do" method="GET">
            <input type="submit" name="Submit" value="导出"></td>
        </form>
    </div>
    <div>
        <%--<input type="button" value="导出" onclick="exportExcle();">--%>
        <form action="/oscar/exceldownload.do" method="POST">
            <input type="text" name="userId">
            <input type="submit" name="Submit" value="下载Excel"></td>
        </form>
    </div>
    <div>
        <form action="/oscar/excelupload.do" method="post" enctype="multipart/form-data" name="form1">
            <table width="100%" border="0" cellspacing="1" cellpadding="0">
                <tr>
                    <td>&nbsp;</td>
                    <td><label>上传
                        <input type="file" name="file">
                    </label></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;<input name="aaaa" type="text" value="asdsadas">
                        <input type="submit" name="Submit" value="提交"></td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <form action="/oscar//uploadImage.do" method="post" enctype="multipart/form-data" name="form2">
            <table width="100%" border="0" cellspacing="1" cellpadding="0">
                <tr>
                    <td>&nbsp;</td>
                    <td><label>上传图片
                        <input type="file" name="file">
                    </label></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input name="userId" type="text" value="">
                    </td>
                    <td>
                        <input name="userName" type="text" value="">
                    </td>
                    <td>
                        <input type="submit" name="Submit" value="提交">
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
