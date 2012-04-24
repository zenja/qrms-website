<div id="my_profile_navigation_div">

<ul style="list-style-type:none;padding-left:0;margin-left:0;">

<li>
<img border="0" width="20" height="20" src="<%=request.getContextPath()%>/images/user/my-messages.png">
<a href="<%=request.getContextPath()%>/user/viewAllInternalMessages.action">My internal messages</a>
</li>

<li>
<img border="0" width="20" height="20" src="<%=request.getContextPath()%>/images/user/my-stared-games.png">
<a href="<%=request.getContextPath()%>/user/viewStaredGames.action?userId=${sessionScope.user.id}">My stared games</a>
</li>

<li>
<img border="0" width="20" height="20" src="<%=request.getContextPath()%>/images/user/my-profile-home.png">
<a href="<%=request.getContextPath()%>/user/showMyProfileMainPage.action">Return to My Profile</a>
</li>

</ul>

</div>

<hr />