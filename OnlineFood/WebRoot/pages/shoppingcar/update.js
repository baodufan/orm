function updateNum(id,txt,oldNum){
	var newNum=txt.value;//获取用户输入的数量
	if(confirm("确定要修改购买数量吗?")){
		location.href="Shopcart?method=updateCart&itemid="+id+"&num="+newNum;
	}else{
		txt.value=oldNum;
	}
	
}