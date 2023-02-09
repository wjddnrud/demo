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

    <h3>게시판</h3>

    <div class="writeBtn">
        <button type="button">글 작성</button>
    </div>

    <table>
        <thead>
            <tr>
                <td>번호</td>
                <td>작성자</td>
                <td>제목</td>
                <td>작성일자</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList}" var="list">
            <tr>
                <td><c:out value="${list.board_seq}"/> </td>
                <td><c:out value="${list.writer}"/></td>
                <td><c:out value="${list.contents}"/></td>
                <td><c:out value="${list.createDate}"/></td>
            </tr>
        </c:forEach>
<%--            <tr>--%>
<%--                <td>2</td>--%>
<%--                <td>작성자</td>--%>
<%--                <td>제목입니다.</td>--%>
<%--                <td>작성일자</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>3</td>--%>
<%--                <td>작성자</td>--%>
<%--                <td>제목입니다.</td>--%>
<%--                <td>작성일자</td>--%>
<%--            </tr>--%>
        </tbody>
    </table>

</body>
</html>