LYD.openLink = function(cfg){
	cfg = typeof cfg == 'object' ? cfg : {};
	$.ajax({
		type:cfg.method||'post',
		url:cfg.url||LYD.defaultUrl(),
		cache: false,
		data: cfg.params||{e:''},
		dataType:"json",
		success: cfg.success||function (){
		},
		error:cfg.error||function (){
		}
	});
}