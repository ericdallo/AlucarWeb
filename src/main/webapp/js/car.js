$(document).ready(function() {
	$('.j_uploadImage').change(function() {
		previewImage(this);
	});

	function previewImage(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('.j_imageUploaded').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

})