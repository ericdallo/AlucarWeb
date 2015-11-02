$(document).ready(function() {
	$(".credit-box").hide();
	$(".debit-box").hide();
	
	$('.radio-payment').click(function() {
		if ($(this).attr("value") == "CREDIT") {
			$(".credit-box").show();
			$(".debit-box").hide();
		}else if ($(this).attr("value") == "DEBIT") {
			$(".credit-box").hide();
			$(".debit-box").show();
		}
		
		$('.payment-form #payment-radio').remove();
		$('.payment-form').append('<input type="hidden" id="payment-radio" name="payment.type" value="'+ $(this).val() +'" />');
	});
});