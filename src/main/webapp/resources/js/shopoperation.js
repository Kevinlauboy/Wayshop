$(function() {
	var initUrl = '/wayshop/shopadmin/getshopinitinfo';
	var registerShopUrl = '/wayshop/shopadmin/registershop';
	getShopInitInfo();

	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var temptempShopHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index) {
					temptempShopHtml += '<option data-id="'
							+ item.shopCategoryId + '">'
							+ item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$("#shop-category").html(temptempShopHtml);
				$("#shop-area").html(tempAreaHtml);
			}

		});
	}
	$('#submit').click(function() {
		var shop = {};
		shop.shopName = $('#shop-name').val();
		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		shop.area = {
			areaId : $('#shop-area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();

		var shopImg = $('#shop-img')[0].files[0];
		shop.shopDesc = $('#shop-desc').val();

		var formData = new FormData();
		formData.append('shopImg', shopImg);
		formData.append('shopStr', JSON.stringify(shop));
		var verifyCodeActual = $('#j_captcha').val();

		if (!verifyCodeActual) {
			$.toast('请输入验证码');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		$.ajax({
			url : registerShopUrl,
			type : 'POST',
			data : formData,
			cache : false,
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.success) {
					$.toast('提交成功!')
				} else {
					$.toast('提交失败!' + data.errMsg);
				}
				$('#captcha_img').click();
			},
			error : function() {
				alert("失败");
			}

		});
	})
})