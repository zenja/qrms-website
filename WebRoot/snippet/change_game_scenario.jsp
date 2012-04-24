<script type="text/javascript">
$(document).ready(function() { 
	$('#change_game_scenario_a').click(function() { 
		$.blockUI({ message: $('#change_game_scenario_main_div'), css:{textAlign: 'left', width: '270px', padding: '0 35px'} });
	
		$('.blockOverlay').attr('title','Click to unblock').click($.unblockUI);
	});
});
</script>

<div id="change_game_scenario_main_div" style="display:none">
<p>Choose a game scenario:</p>
<table width="100%%" border="0" cellspacing="5" cellpadding="5">
	<tr>
		<td><a href="<%=request.getContextPath()%>/inspiring_mode"><img title="Inpiring Mark" width="72" height="72" border="0" src="<%=request.getContextPath()%>/images/inspiring.png" /></a></td>
		<td><a href="<%=request.getContextPath()%>/puzzle-solving-index.jsp"><img title="Puzzle Solving" width="72" border="0" height="72" src="<%=request.getContextPath()%>/images/puzzle.png" /></a></td>
		<td><a href="<%=request.getContextPath()%>/conquest_and_defence"><img title="Conquest & Defence" width="72" border="0" height="72" src="<%=request.getContextPath()%>/images/defend.png" /></a></td>
	</tr>
</table>
</div>