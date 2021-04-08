window.addEventListener( "load", function () {
	let url = '/admin/get-users';	
	fetch(url, {credentials: 'include'}).then((response) => {
		return response.text();
	})
	.then((text) => {
		let userArray = JSON.parse(text);
		let mainPart = document.querySelector("main");
		mainPart.insertAdjacentHTML("beforeend", "<table id=users><caption>All users</caption></table>");
		let table = document.getElementById("users");
		table.insertAdjacentHTML("beforeend", 
			"<tr><th>ID</th><th>Email</th><th>Name</th><th>Surname</th><th>Address</th><th>Role</th></tr>");
		userArray.forEach(function(user){
			table.insertAdjacentHTML("beforeend", 
			"<tr><td>"+user.id+"</td><td>"+user.email+"</td><td>"+user.name+"</td><td>"+user.surname+"</td><td>"+user.address+"</td><td>"+user.role.name+"</tr></tr>");
		});
	});
	let message = document.getElementById("message");
	
//	function logout(){
//		let url = '/admin/logout';
//		message.innerHTML="";
//		fetch(url, {		
//			method: "DELETE",
//			credentials: 'include'
//		})
//		.then((response) => {
//			if(response.ok)				
//				document.location.href = "../index.html";
//			else{
//				message.style.color = "darkred";
//				message.style.backgroundColor = "lightpinks";
//				message.innerHTML="Something went wrong.";
//			}	
//		});
//	}
	
	
	let logoutButton = document.getElementById("logout");
	logoutButton.addEventListener("click", function logout(){
		let url = '/admin/logout';
		message.innerHTML="";
		fetch(url, {		
			method: "DELETE",
			credentials: 'include'
		})
		.then((response) => {
			if(response.ok)				
				document.location.href = "../index.html";
			else{
				message.style.color = "darkred";
				message.style.backgroundColor = "lightpinks";
				message.innerHTML="Something went wrong.";
			}	
		});
	});
});