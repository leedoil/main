function payment () {
        var IMP = window.IMP; // 생략가능
      //var alltotal = allTotal;
      var user_email = $("#cf_email").val();
      var user_phone = $("#cf_phone").val();
      var user_zip = $("#cf_zip").val();
      var user_address = $("#cf_street_address").val();
      var user_name = $("#cf_name").val();
      
      console.log(alltotal);
        IMP.init("imp73760842"); 
        // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
        IMP.request_pay({
            pg: 'html5_inicis',
            pay_method: 'card',
            merchant_uid: 'ORD20221116-0000015',
            name: 'COLURR : CheckOut',
            amount: allTotal, 
            buyer_email: user_email,
            buyer_name: user_name,
            buyer_tel: user_phone,
            buyer_addr: user_address,
            buyer_postcode: user_zip,
            m_redirect_url: 'https://www.colurr.com/order/checkout_complete'

         
            /*  
                모바일 결제시,
                결제가 끝나고 랜딩되는 URL을 지정 
                (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐) 
                */
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;

            location.href = 'www.colurr.com';
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
        })
}