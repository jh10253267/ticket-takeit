<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 </title>
</head>
<body>
<div>
    <div>
        <form method="post" action="/authenticate">
            <div>
                <label>ID</label>
                <input type="text" name="loginEmail">
            </div>
            <div>
                <label>암호</label>
                <input type="password" name="password">
            </div>
            <div>
                <input type="submit" value="로그인">
            </div>
            <div>
                <input type="checkbox" name="remember-me">
                <label for="remember-me">자동로그인</label>
            </div>
        </form>
    </div>
</div>
</body>
</html>