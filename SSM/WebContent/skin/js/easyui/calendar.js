$(function(){
	
	$("#et").calendar({
		border : true,
		fit : true,
		firstDay : 1,
		/*formatter : function(date){
			return date.getDate() + "-et";
		}*/
		onSelect: function(date){
			alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
		}
	});
	
});