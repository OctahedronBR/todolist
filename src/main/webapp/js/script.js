$(function() {
	$("input[type=checkbox]").change(function(e) {
		var $this = $(this),
			$description = $this.find("~ .description"),
			checkbox = this;
		
		$.post('/update', { 'id': $this.closest("div").data('id'), 'completed': this.checked }, function(data) { 
			if (checkbox.checked) {
				$description.addClass("done");
			} else {
				$description.removeClass("done");
			}
		});
	});
	
	$(".delete").click(function(e) {
		var $this = $(this);
		$.post('/delete', { 'id': $this.closest("div").data('id') }, function(data) { 
			$this.closest("li").remove();
		});
	});
});
