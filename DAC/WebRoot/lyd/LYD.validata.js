
LYD.isEmail = function(obj) {
	reg = /^\w{1,}@\w+(\.\w+)+$/;
	if (!reg.test(obj)) {
		return false;
	} else {
		return true;
	}
}
LYD.isPass = function(obj){
	r = /^[a-zA-Z0-9]{6,}$/;
	if (!r.test(obj)) {
		return false;
	} else {
		return true;
	}
}