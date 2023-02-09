<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판</title>

    <style type="text/css">
        * {
            align-content: center;
        }

        .writeBtn {

        }

    </style>
</head>
<body>
    <form name="boardForm" method="post">
        <h3>게시글 작성 폼</h3>

        <input type="text">
        <input name="title" type="text">
        <textarea name="contents"></textarea>
        <button type="submit">등록하기</button>
    </form>
</body>
</html>