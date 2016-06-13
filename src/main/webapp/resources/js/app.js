$(document).ready(function() {
	$("#skillList").sortable();

	$("body").on('click', '#skillList .delete', function () {
		var selSkill = $(this).closest( ".list-group-item" ).find("input[type=text]").val();
	    $(this).closest( ".list-group-item" ).remove();	   
	    $("#fromDay option[value="+selSkill+"]").remove();
	});

	$("#addSkill").click(function () {
		var skill = $("#skill").val();
		var flag = false;
		$("#fromDay option").each(function(){
				   if($(this).val() == skill){
					   flag = true;					   
				   }
		});		
		
		if(flag == false){
		    $('#skillList').append("<li class='list-group-item skillList'><input type='text' class='inp' name='skillList' style='background:rgba(0,0,0,0);border:none' value='"+skill+"' disabled/><a class='delete'><span class='glyphicon glyphicon-remove pull-right skillIcon'></span></a></li>");
		    $("#fromDay").append(new Option(skill,skill));
		    $('#fromDay option').prop('selected', true);
		    $("#skill").val("");
		}
	});

});
