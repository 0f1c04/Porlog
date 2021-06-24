/**
 * 공통자바스크립트 
 */
var replyManager = ( function() {
	var getAll = function(obj, callback) {
		console.log("getAll......" + obj);
		$.getJSON("/replies/post/" + obj, callback);
		
	};
	var add = function(obj, callback) {
		console.log("add reply......");
		$.ajax({
			url:"/replies/" + obj["postID"],
			data:  obj ,
			type: "post",
			success: callback
		});
	};
	var update = function(obj, callback) {
		console.log("update reply......");
		$.ajax({
			url:"/replies/" + obj["postID"],
			data: obj,
			type: "put",
			success: callback
		});
	};
	var remove = function(obj, callback) {
		console.log("remove reply......");
		alert(obj.postID);
		$.ajax({
			url:'/replies/' + obj['postID'] + "/" + obj['replyNO'],
			type: 'delete',
			success: callback
		});
	};
	return {
		"getAll": getAll, "add": add, "update": update, "remove": remove
	};
})();
