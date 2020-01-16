<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
  <form name="serForm" action="/oscar/filetest/fileUpload1" method="post"  enctype="multipart/form-data">
    <h1>采用流的方式上传文件</h1>
    <input type="file" name="file">
    <input type="text" name="fileName">
    <input type="submit" value="upload"/>
  </form>
</div>

<div>
  <form name="Form2" action="/oscar/filetest/fileUpload2" method="post"  enctype="multipart/form-data">
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
  </form>
</div>

<div>
  <form name="Form2" action="/oscar/filetest/fileUpload3" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
  </form>
</div>
</body>
</html>
