$(function(){
	//下拉列表
	$("#et").combobox({
		url : contextPath + '/combobox/getGender.do',
		textField : 'label',
		valueField : 'value',
		panelHeight : 80,
		/*data: [{
			label: 'et-java',
			value: 'Java'
		},{
			label: 'et-perl',
			value: 'Perl'
		},{
			label: 'et-ruby',
			value: 'Ruby'
		}],*/
		onSelect : function(r){
			console.log(r.label + "|" + r.value);
		}
	});
	
});