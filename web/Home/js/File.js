var nextfile="";
var name;//用户账号名
var RemmberNext_back="";
function ONece(){
	name=$("#namespan").text();
	
}

/******************三个功能按钮*********************/
/******************
跳转必须做的几件事
1.记住当前路径
2.设置nextfile

********************/
function RemmberNext(x){
	RemmberNext_back=x; 
}
 $(function(){//回到上一步按钮
	$("#File-dictoryi-return").click(function(){
		var nextfilegroup=nextfile.split("/");
		var  substring=nextfilegroup[nextfilegroup.length-1];
		document.getElementById("FileName").innerHTML = "";//去除所有子节点
		document.getElementById("SpecificFile").innerHTML = "";//去除所有子节点
		nextfile=nextfile.replace("/"+substring, '');
		RemmberNext(nextfile);//记住跳转的路径，下次可以回到这个页面
		ik(nextfile);
		
	});
});

$(function(){
	$("#File-dictoryi-middle").click(function(){
		document.getElementById("FileName").innerHTML = "";//去除所有子节点
		document.getElementById("SpecificFile").innerHTML = "";//去除所有子节点
		RemmberNext(nextfile);//记住跳转的路径，下次可以回到这个页面
		nextfile="";
		ik(nextfile);//主页就是没有任何路径的
	});
});
$(function(){
	$("#File-dictoryi-forward").click(function(){
		document.getElementById("FileName").innerHTML = "";//去除所有子节点
		document.getElementById("SpecificFile").innerHTML = "";//去除所有子节点		
		var Middle_RemmberNext_nextfile=nextfile;
		ik(RemmberNext_back);//先跳转至下一页，再改RemmberNext_back为跳转前的nextfile
		nextfile=RemmberNext_back;
		RemmberNext(Middle_RemmberNext_nextfile);
	});
});
/*********************AJAX技术，与后台交互，得到目录文件夹下的文件夹与文件名称**********************************/
 	function ik(without_name_nextfile){	
		var completion_name=name+without_name_nextfile;
			$.ajax({
			       url:'/Home/File',
			       async: false,
			       type: "POST",  
			       data: { "name":completion_name },
			       success: function(msg){
			              var fileName = eval("("+msg+")");
			              Parsing(fileName);
			              
			       } 
			});
	}
ONece();
ik(nextfile);
/*****************************/

function Parsing(fileName){
	 Filegroup_Directory=fileName.DirectoryName;
	 Filegroup_File=fileName.FileName;
	 Add_Directory_Name_out(Filegroup_Directory);
	 Add_File_Name_out(Filegroup_File);
 }
/*js原生增加节点*/
function Add_Directory_Name_out(jsonObj){
		for (x in jsonObj) {
			directoryName=jsonObj[x];
			li = document.createElement("li");
			li.id="li-id"+directoryName;
			li.className="li-class";
			checkId="checkbox"+directoryName;
			
			html = "<a  id=\""+checkId+"\" class=\"check\" name=\"activity\" value= "+directoryName+" ><div>&nbsp+</div></a><a class=\"ali\"><span>"+directoryName+"</span></a>";//	document.getElementById("FileName").innerHtml("<li><a><span>"+name+"</span></a></li>");
			li.innerHTML = html;
			document.getElementById("FileName").appendChild(li);
		}
}

function Add_File_Name_out(jsonObj){//将文件信息添加到详细页面
	for (x in jsonObj) {
		var fileName=jsonObj[x];
		span = document.createElement("span");
		span.id="span-id"+fileName;
		span.className="span-class";

		html ="<div class=\"SpecificFile_fileName_div\">"+fileName+"</div>";
		span.innerHTML = html;
		document.getElementById("SpecificFile").appendChild(span);
	} 
}
$("#SpecificFile").delegate(".span-class", "dblclick", function () {//双击文件使其下载
	filename_Adress=$(this).text();alert(filename_Adress);
	Download_File(filename_Adress);
	
	
	
	
});
function Download_File(filename_Adress){	
		filename_Adress=name+nextfile+"/"+filename_Adress;
			form = $("<form>");
		    form.attr('style', 'display:none');
		    form.attr('target', '');
		    form.attr('method', 'post'); //请求方式
		    form.attr('action', "/Home/File/Download_Servlet");//请求地址
		 
		    input = $('<input>');//将你请求的数据模仿成一个input表单
		    input.attr('type', 'hidden');
		    input.attr('name', "filename_Adress");//该输入框的name
		    input.attr('value',filename_Adress);//该输入框的值
		 
		    $('body').append(form);
		    form.append(input);
		    form.submit();
		    form.remove();

}
$("#FileName").delegate(".ali", "click", function () {//选择FileName下的.ali元素进行跳转至其下目录。包括未来元素，添加事件
		var FileName1=$(this).text();
		
//    这种方法只适用于删除一个节点的：var element=document.getElementsByClassName("li-class");alert(element);element.parentNode.removeNode(element);
	RemmberNext(nextfile);//记住跳转的路径，下次可以回到这个页面
	nextfile=nextfile+"/"+FileName1;//这里是最重要的一步，同步nextfile。1."" 2."/示例1" 3."/示例1/示例三"
	document.getElementById("FileName").innerHTML = "";
	/*第二种方式去除子节点
	*elements=document.getElementsByClassName("li-class");
	*for(var i = elements.length - 1; i >= 0; i--) { 
	*  elements[i].parentNode.removeChild(elements[i]); 
	*}
	*/
	
	document.getElementById("SpecificFile").innerHTML = "";//去除所有子节点
		ik(nextfile);	
});
/**********************************************/
/**********************************************/
/**********************************************/
$("#FileName").delegate(".check", "click", function () {//点击+号可以让它去上面的栏目中
		var fileName=$(this).attr("value");
		aspan=document.createElement("span");
		aspan.id="aspan"+fileName;
		
		aspan.setAttribute("data-key", nextfile+"/"+fileName);
		aspan.className="aspan-class";
	
		html = "<a ><span>"+fileName+"</span></a>";//<span id=fileName class=aspan-class><a ><span>"+fileName+"</span></a></span>
		aspan.innerHTML = html;
		document.getElementsByClassName("File-tile")[0].appendChild(aspan);
});
$(".File-tile").delegate(".aspan-class", "dblclick", function () {//双击上面的栏目中的元素，可以使其消除
		var fileName=$(this).text();
		Telement=document.getElementById("aspan"+fileName);//删除上面的元素
	 	Telement.parentNode.removeChild(Telement);
	 	
});
$(".File-tile").delegate(".aspan-class", "click", function () {//单击上面的栏目中的元素，可以使其跳转
		
		var fileName_nextfile=$(this).attr("data-key");alert("单双击上面的栏目中的元素，可以使其跳转"+fileName_nextfile);
		
	 	document.getElementById("FileName").innerHTML = "";//去除所有子节点
		document.getElementById("SpecificFile").innerHTML = "";//去除所有子节点
		nextfile=fileName_nextfile;
		ik(nextfile);
});





 

//function loadingPersonchoosepage(){
////	插入节点的一种方式document.getElementsByClassName("personchoose").innerHTML = '<object type="text/html" data="index.html" width="100%" height="100%"></object>';
////	注意：需要在服务器环境下，否则会报跨域错误   document.getElementsByClassName("personchoose").innerHTML = personchoosepage.import.body.innerHTML;			
//}
