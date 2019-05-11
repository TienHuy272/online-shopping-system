$(document).ready(function() {
	$("#resultSearch").hide();
	$("#searchProductName").keyup(function() {
		var productName = $("#searchProductName").val();
		var str = "<ul style='list-style-type:none' class='dropdownSearch'>";
		var a = "";
		$.ajax({
			url : "findProductByName",
			type : "post",
			data : {
				"productName" : productName
			},
			success : function(value) {
//				alert("Success");
				if (value !== "Fail Searching") {
					if (productName !== "") {
						$.each(JSON.parse(value), function(k, v) {
							str = str + "<li><a href='productDetails?pageNumber=1&id="+ v.productId +"'>"
									+v.productName + "</a></li>";
						});
						str = str + "</ul>";
						$("#resultSearch").html(str);
						$("#resultSearch").slideDown("slow");
					} else {
						$("#resultSearch").slideUp("slow");
					}
				}
			},
			error : function() {
				alert("Fail");
				$("#resultSearch").slideUp("slow");
			}
		});
	});
});

$(document).mouseup(
		function(e) {
			if ($("#resultSearch") !== e.target
					&& $("#resultSearch").has(e.target).length === 0) {
				$("#resultSearch").slideUp("fast");
			}
		});