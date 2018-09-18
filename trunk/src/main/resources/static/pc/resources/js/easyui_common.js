$(function(){
	getResourcesJs();
})
	
 

function getResourcesJs(){
	var newscript1=document.createElement('script');
	newscript1.setAttribute('type','text/javascript');
	newscript1.setAttribute('src','../resources/js/easyui/jquery.easyui.min.js');
	document.body.appendChild(newscript1);
}