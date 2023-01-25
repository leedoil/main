/**
 * 
 */
function clickCart() {
   form.proCount = $(".Quantity").val();
   $.ajax({
      url: "${root}cart_add",
      type: 'GET',
      data: form,
      success: function(result) {
         cartAlert(result);
      }
   })
}

function cartAlert(result) {
   if (result == 1) {
      alert("장바구니에 추가되었습니다.");
   } else if (result == 5) {
      alert("로그인이 필요합니다.");
   }
}

let quantity = $(".Quantity").val();
$(".inc qty-btn").on("click", function(){
   $(".Quantity").val(++quantity);
});
$(".dec qty-btn").on("click", function(){
   if(quantity > 1){
      $(".Quantity").val(--quantity);   
   }
});

//서버로 전송할 데이터
const form = {
   user_idx : '${loginUserBean.user_idx}',
   product_idx : '${product_idx}',
   proCount : ''
}