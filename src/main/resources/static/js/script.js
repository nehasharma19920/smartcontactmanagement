console.log("this is script file");
function showPassword() {
	  var x = document.getElementById("password");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}




var input = $("#show_hide_password input");
var icon = $("#show_hide_password i");

icon.on('click', function(event) {
	event.preventDefault();

	if (input.attr("type") === "text") {
		input.attr('type', 'password');
		icon.addClass("fa-eye-slash");
		icon.removeClass("fa-eye");

	} else if (input.attr("type") === "password") {
		input.attr('type', 'text');
		icon.removeClass("fa-eye-slash");
		icon.addClass("fa-eye");
	}
});
const toggleSidebar = () =>{
	if($('.sidebar').is(":visible")){
		$(".sidebar").css("display","none");
		$(".content").css("margin-left","0%")
	}
	else{
		
		$(".sidebar").css("display","block");
		$(".content").css("margin-left","20% ")
		
	}
}
