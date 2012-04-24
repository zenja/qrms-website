var nicknameMax=20;
var nicknameMin=4;
var passMax=20;
var passMin=4;

	
function getObj(objName){return(document.getElementById(objName));} 
function hide(objName){getObj(objName).style.display="none";}
function show(objName){getObj(objName).style.display="inline";}

function checkEmail(){
	var emailValue=getObj("email1").value;
	var emailRegExp=/^(?:[a-z\d]+[_\-\+\.]?)*[a-z\d]+@(?:([a-z\d]+\-?)*[a-z\d]+\.)+([a-z]{2,})+$/i;
	if(emailValue==""){
		hide("EmailAddressValidation");
		show("EmailAddressExistsValidation");
	//	alert("emailfalse");
		return false;
	}
	else if(!emailValue.match(emailRegExp)){
		hide("EmailAddressExistsValidation");
		show("EmailAddressValidation");
	//	alert("emailfalse");
		return false;
	}else{
		hide("EmailAddressValidation");	
		hide("EmailAddressExistsValidation");
	//	alert("emailtrue");
		return true;
	}
}

function checkReEmail() 
{  
	var emailValue=getObj("email1").value;
	var reEmailValue=getObj("email2").value;
	if (reEmailValue=="")
	{ 
		hide("EmailAddressCompare");
		show("EmailAddressConfirmValidation");
	//	alert("reemailfalse");
		return false; 
	}
	else if (emailValue!=reEmailValue)  
	{  
		hide("EmailAddressConfirmValidation");
		show("EmailAddressCompare");
	//	alert("reemailfalse");
		return false;
	}else{ 
		hide("EmailAddressCompare");
		hide("EmailAddressConfirmValidation");
	//	alert("reemailtrue");
		return true;
	}
}

function checkPassword() 
{  
	var passValue=getObj("password1").value;
	if (passValue=="") 
	{ 
		hide("PasswordLengthValidation");
		show("PasswordValidation");
		//alert("pwd0false");
		return false; 
	}
	else if (passValue.length<passMin||passValue.lenth>passMax)  
	{  
		hide("PasswordValidation");
		show("PasswordLengthValidation");
	//	alert("pwd0false");
		return false;
	}else{ 
		hide("PasswordValidation");
		hide("PasswordLengthValidation");
	//	alert("pwd0true");
		return true;
	}
} 

function checkRePassword() 
{  
	var passValue=getObj("password1").value;
	var passConfirmValue=getObj("password2").value;
	if (passConfirmValue=="") 
	{ 
		hide("PasswordConfirmationCompare");
		show("PasswordConfirmValidation");
	//	alert("pwdfalse");
		return false; 
	}
	else if (passValue!=passConfirmValue)  
	{  
		hide("PasswordConfirmValidation");
		show("PasswordConfirmationCompare");
	//	alert("pwdfalse");
		return false;
	}else{ 
		hide("PasswordConfirmValidation");
		hide("PasswordConfirmationCompare");
	//	alert("pwdtrue");
		return true;
	}
}

function checkNickname(){
	var nicknameValue=getObj("nickname").value;
	var nicknameRegExp= /^[a-zA-Z0-9_]{1,}$/; 
	if(nicknameValue.length<nicknameMin||nicknameValue.length>nicknameMax){
		hide("UserNameLeagalValidation");
		show("UserNameLengthValidation");
	//	alert("namefalse");
		return false;
	}else if(!nicknameValue.match(nicknameRegExp)){
		hide("UserNameLengthValidation");
		show("UserNameLeagalValidation");
	//	alert("namefalse");
		return false;
	}else{
		hide("UserNameLeagalValidation");	
		hide("UserNameLengthValidation");
	//	alert("nicktrue");
		return true;
	}
}

function checkAgree(){
	var agreeValue=getObj("agree").checked;
	if(agreeValue!=true){
		show("privacyValidation");
	//	alert("aggreefalse");
		return false;
	}else{
		hide("privacyValidation");
	//	alert("aggreetrue");
		return true;
	}
	
}

function checkAll(){
	
	checkEmail();
	checkReEmail();
	checkPassword();
	checkRePassword();
	checkNickname();
	checkAgree();
	if(	checkEmail()&&
		checkReEmail()&&
		checkPassword()&&
		checkRePassword()&&
		checkNickname()&&
		checkAgree())
	{
	//	alert("true");
		return true;	
	}
	else{
	//	alert("false");
	return false;
}
}