$(document).ready(function() {
	$(".quantity").change(function() {
		var quantity = $(this).val();
		var productId = $(this).attr("data-id");
		var unitPrice = $('#' + productId + 'UnitPrice').text();
		var price = quantity * unitPrice;
		var quantityInAjax = 0;
		var unitPriceInAjax = 0;
		var totalPrice = 0;
		var numberOfProduct = 0;
		$.ajax({
			url : "updateProduct",
			type : "post",
			data : {
				"quantity" : quantity,
				"productId" : productId,
			},
			success : function(value) {
				$.each(JSON.parse(value), function(k, v) {
					quantityInAjax = v;
					unitPriceInAjax = JSON.parse(k).unitPrice;
					totalPrice = totalPrice + unitPriceInAjax * quantityInAjax;
					numberOfProduct = numberOfProduct + quantityInAjax;

				});
				$(".cart-amunt").text(totalPrice.toFixed(1));
				$(".product-count").text(numberOfProduct);
				$('#' + productId + 'Price').text(price.toFixed(1));
			}
		});
	});

	$(".remove").click(function() {
		var productId = $(this).attr("data-id");
		var quantity = 0;
		var unitPrice = 0;
		var totalPrice = 0;
		var numberOfProduct = 0;
		$.ajax({
			url : "removeProduct",
			type : "post",
			data : {
				"productId" : productId,
			},
			success : function(value) {
				$('#' + productId).remove();
				$.each(JSON.parse(value), function(k, v) {
					quantity = v;
					unitPrice = JSON.parse(k).unitPrice;
					totalPrice = totalPrice + unitPrice * quantity;
					numberOfProduct = numberOfProduct + quantity;

				});
				$(".cart-amunt").text(totalPrice.toFixed(1));
				$(".product-count").text(numberOfProduct);
			}
		});
	});
});