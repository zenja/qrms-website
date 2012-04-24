<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<div id="make_comment_form_div" style="display:none;">
<s:form theme="simple" action="makeGameCommentForPuzzleSolving" method="post" enctype="multipart/form-data">

<input type ="hidden" name="gameComment.gameId" value="${param.gameId}" />
<!-- Change To Corresponding Game Type -->
<input type ="hidden" name="gameComment.gameType" value="2" />

<label class="mylabelstyle">Type of comment:</label>
<select name="gameComment.commentType"> 
    <option value="1">Found it</option>
    <option value="2">Didn't find it</option>
    <option value="3" selected="selected">Write note</option>
    <option value="4">Needs Maintenance</option>
</select>

<br />

<label class="mylabelstyle">Image File(Not Required):</label>
<input type="file" name="pictureFile"/>

<label class="mylabelstyle">Comments</label>
<s:textarea name="gameComment.textcomment" rows="10" cols="40" cssStyle="display:inline-block;"></s:textarea>

<p>
<s:submit cssClass="mysubmitstyle" label="Submit"></s:submit>
</p>

</s:form>
</div>