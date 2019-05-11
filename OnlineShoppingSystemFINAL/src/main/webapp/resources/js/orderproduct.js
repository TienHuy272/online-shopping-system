$(document).ready(function() {   
	$(".add_to_cart_button").on("click", function() {
		var productId = $(this).attr("data-id");
		var quantity = 0;
		var unitPrice = 0;
		var totalPrice = 0;
		var numberOfProduct = 0;
		$.ajax({
			url : "productOrder",
			type : "POST",
			data : {
				"productId" : productId
			},
			success : function(value) {
				alert("Successfull Sending");
				if (value === "Fail Ordering") {
					window.location.href = "customerLogin";
				} else {
					alert("Product Was Ordered Successfully");
					$.each(JSON.parse(value), function(k, v) {
						quantity = v;
						unitPrice = JSON.parse(k).unitPrice;
						totalPrice = totalPrice + unitPrice * quantity;
						numberOfProduct = numberOfProduct + v;

					});
					$(".cart-amunt").text(totalPrice.toFixed(1));
					$(".product-count").text(numberOfProduct);
				}
			},
			error : function() {
				alert("Fail Sending");
			}
		});
	});
});