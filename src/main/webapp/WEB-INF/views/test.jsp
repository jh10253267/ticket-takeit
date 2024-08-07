<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<button onClick="request_pay()">결제하기</button>
<script>
    IMP.init("imp46607110");
    IMP.request_pay({
        pg: 'kakaopay',
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '주문명:결제테스트',
        amount: 14000,
        buyer_email: 'iamport@siot.do',
        buyer_name: '구매자이름',
        buyer_tel: '010-1234-5678',
        buyer_addr: '서울특별시 강남구 삼성동',
        buyer_postcode: '123-456'
    }, function (rsp) {
        if (rsp.success) {
            //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            jQuery.ajax({
                url: `/payments/confirm/${rsp.imp_uid}`, //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST'
            }).done(function (data) {
                if (true) {
                    jQuery.ajax({
                        url: `/payments/complete/${rsp.imp_uid}`,
                        type: 'POST'
                    }).done(function (data){
                        console.log(data);
                        let baseMsg = '결제가 완료되었습니다.';
                        baseMsg += '\n고유ID : ' + rsp.imp_uid;
                        baseMsg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        baseMsg += '\n결제 금액 : ' + rsp.paid_amount;
                        baseMsg += '카드 승인번호 : ' + rsp.apply_num;

                        alert(baseMsg);
                    });
                }
            });
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;

            alert(msg);
        }
    });
</script>
</body>
</html>
