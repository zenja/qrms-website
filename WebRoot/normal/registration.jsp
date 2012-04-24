<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sign Up!</title>
<link rel="stylesheet" type = "text/css" href="<%=request.getContextPath()%>/css/registration.css"/>
<link href="<%=request.getContextPath()%>/css/form_new.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#registrationForm").validate( {
		event: "blur",
		rules : {
			"nvuser.name" : {
				required : true,
				minlength : 4,
				maxlength : 16
			},
			"nvuser.loginEmail" : {
				required : true,
				email : true
			},
			"nvuser.password" : {
				required : true,
				minlength : 4, 
				maxlength : 16
			},
			password : {
				required : true,
				minlength : 4,
				maxlength : 16,
				equalTo : "#password1"
			},
			agree: "required"
		},
		messages : {
			"nvuser.name" : {
				required : "You must enter a name.",
				minlength : jQuery.format("Name can not be less than {0} characters"),
				maxlength : jQuery.format("Name can not be more than {0} characters")
			},
			"nvuser.loginEmail" : {
				required : "You must enter an e-mail address",
				email : "Email address invalid!"
			},
			"nvuser.password" : {
				required : "You must enter your password.",
				minlength : jQuery.format("Password can not be less than {0} characters"),
				maxlength : jQuery.format("Password can not be more than {0} characters")
			},
			password : {
				required : "You must re-enter your password.",
				minlength : jQuery.format("Password can not be less than {0} characters"),
				maxlength : jQuery.format("Password can not be more than {0} characters"),
				equalTo : "Your password and re-entered password do not match."
			},
			agree: "Please accept our policy"
		}
	});
});
</script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/checkLoginEmail.js">
 
</script>

</head>

<body>

<s:form name="form" theme="simple" id="registrationForm" action="userRegister" method="post">

<label class="mylabelstyle">Email:</label>
<s:textfield cssClass="myinputstyle" id="email1" name="nvuser.loginEmail" size="40" onblur="isExist();"/>

<label class="mylabelstyle">Password:</label>
<s:password cssClass="myinputstyle" id="password1" name="nvuser.password" size="40"/>

<label class="mylabelstyle">Re Enter Password:</label>
<s:password cssClass="myinputstyle" id="password2" name="password" size="40"/>

<label class="mylabelstyle">Name:</label>
<s:textfield cssClass="myinputstyle" id="nickname" name="nvuser.name" size="40"/>

<label class="mylabelstyle">Terms of Use and Privacy Statement:</label> 


<div id="statement">
<p><strong>QR MARKS THE SPOT SITE TERMS OF USE AGREEMENT</strong></p>
<p>Last updated: Dec 10, 2010</p>
<p>Welcome to our website, the QR Marks the Spot. This Web site includes access to the related information about the game based on the QR Marker, the QR Marks the Spot Forums and such other services and sites. (the "Site") These Terms of Use form a legal agreement between the account holder ("You") and QR Marks the Spot, Inc. ("QR Marks the Spot").</p>
<p><strong>1. Information Available at this Site</strong></p>
<p>This Site contains general information about QR Marks the Spot, its activities and its services. This Site also contains information about Marker and related activities published to the Site by users like You.Besides,it contains a Client System based on Android.You can down it freely and play with your friends. Our website does not guarantee the accuracy or timeliness of the information available on this Site. You are solely responsible for verifying the accuracy of any information available on this Site. QR Marks the Spot disclaims responsibility for Your reliance on information at this Site in Section 10 below. </p>
<p><strong>2. Privacy</strong></p>
<p>QR Marks the Spot will use Your personally identifiable information collected in connection with this Site, including without limitation Your name, e-mail address, or other information unique to You ("Personally Identifiable Information"), in the following ways: </p>
<p> (a) QR Marks the Spot may use you personally Identifiable Information to contact with you about the new markers in your area or notify your about the updates on changes to the Site;and to allow you to log your visit to the marker and share your experiences  with other users of the website. </p>
<p> (b) QR Marks the Spot may also use Personally Identifiable Information to statistically analyze usage of the Site; to improve our product and service offerings; to customize the Site's content and layout; and to otherwise improve the Site. </p>
<p>QR Marks the Spot uses cookies and other types of Site user tracking technology to recognize Site visitors and to customize certain Site features and functions for repeat visitors. Information collected using cookies may be combined with Personal Information but may only be used as described herein. Cookies are required in order to log your visit on the Site, and disabling the use of cookies may impact some of the Site features. </p>
<p>QR Marks the Spot will not sell, rent, or otherwise disclose Personally Identifiable Information to any third party, except: (a) in connection with any merger or acquisition of QR Marks the Spot , including without limitation any restructuring activity with another legal entity; or as (b) as required by subpoena, search warrant, or other valid legislative or judicial process. QR Marks the Spot may, however, disclose non-personalized, aggregate data to third parties as may be collected and processed in connection with the Site. </p>
<p><strong>3. License to Use Site; Restrictions</strong></p>
<p>QR Marks the Spot hereby grants You a non-exclusive, non-transferable, revocable license to view and use the Site in accordance with this Agreement and any guidelines or policies posted on the Site. QR Marks the Spot reserves the right to suspend or revoke, in its sole discretion, the license hereunder and to prevent You from accessing all or any portion of the Site with or without notice or reason and without liability on the part of QR Marks the Spot. </p>
<p>QR Marks the Spot may change, suspend, or discontinue any portion of the Site, or any service offered on the Site, at any time, including but not limited to any feature, database, application, or content. QR Marks the Spot may also impose limits on certain features offered on the Site with or without notice. </p>
<p>The Site and all content available on the Site are protected by applicable intellectual property laws, and are for personal and noncommercial use. All rights not expressly granted in this Agreement are reserved by QR Marks the Spot or by the respective owners of the intellectual property rights. All materials available on or through the Site, other than Third Party Submissions (collectively, the "Site Materials") are the property of QR Marks the Spot or of its licensors and are protected by copyright, trademark, and other intellectual property laws. QR Marks the Spot reserves the right to impose additional terms and conditions upon Your use and viewing of particular Site Materials, and any such terms and conditions may be posted on the Site in connection with those Site Materials. You may not reproduce or retransmit the Site Materials, in whole or in part, in any manner, without the prior written consent of the owner of such materials, except as follows: You may make a single copy of the Site Materials solely for Your personal, noncommercial use, but such copying must be consistent with any applicable additional terms and conditions and You must preserve any copyright, trademark, or other notices contained in or associated with such Site Materials. You may not distribute such copies to others, whether or not in electronic form and whether or not for a charge or other consideration, without prior written consent of the owner of such materials. If you have any questions, contact us at wx08@software.nju.edu.cn. </p>
<p>Subscription portions (if any) of the Site may contain additional terms and conditions applicable to use of that portion of the Site, including without limitation password usage and protection rules. If You subscribe to any service at this Site, You will be asked to agree to those terms and conditions as part of the subscription transaction, and those terms and conditions will be deemed incorporated into this Agreement by this reference. </p>
<p><strong>4. Use of Publishing Tools and Forums</strong></p>
<p>All features, functions and areas of the website, including the QR Marks the Spot Forums , are governed by this Agreement and are also subject to such additional terms and conditions as QR Maker SPOT may, from time to time, publicize. </p>
<p>You and not QR Maker SPOT, are entirely responsible for all content that you upload, post or otherwise transmit via the Site. You agree not to: </p>
<p> (a) Upload, post or otherwise transmit any content that is unlawful, harmful, threatening, abusive, harassing, tortuous, defamatory, slanderous, vulgar, obscene, libelous, invasive of another's privacy, hateful, embarrassing, or racially, ethnically or otherwise objectionable to any other person or entity. </p>
<p> (b) Impersonate any person or entity, or falsely state or otherwise misrepresent your affiliation with any person or entity. </p>
<p> (c) Upload, post or otherwise transmit any content that you do not have a right to transmit under any law or under contractual or fiduciary relationship. </p>
<p> (d) Upload, post or otherwise transmit any content that infringes any patent, trademark, trade secret, copyright or other intellectual property or proprietary rights of any person, including without limitation under any privacy or publicity rights. </p>
<p> (e) Upload, post or otherwise transmit any unsolicited or unauthorized advertising, promotional materials, "junk mail," "spam," "chain letters," "pyramid schemes," or any other form of solicitation. </p>
<p> (f) Upload, post or otherwise transmit any content that contains viruses or any other computer code, files or programs which interrupt, destroy, limit the functionality of, or cause damage to the Site or any computer software or hardware or telecommunications equipment. </p>
<p> (g) Disrupt the normal flow of dialogue or otherwise act in a manner that negatively affects other users' ability to engage in real time exchanges. </p>
<p> (h) Interfere with or disrupt the Site or servers or networks connected to the Site, or fail to comply with any requirements, procedures, policies or regulations of networks connected to the Site. </p>
<p> (i) Violate any applicable local, state, national or international law. </p>
<p> (j) "Stalk," harass, or otherwise harm another Site user. </p>
<p> (k) Collect or store personal data about other Site users. </p>
<p> (l) Promote or provide instructional information about illegal activities, promote physical harm or injury against any group or individual. </p>
<p><strong>5. Access and Interference</strong></p>
<p>Much of the information on the Site is updated on a real time basis and is proprietary or is licensed to QR Maker SPOT by our users or third parties. You agree that you will not use any robot, spider, scraper or other automated means to access the Site for any purpose without our express written permission. Additionally, you agree that you will not: (a) take any action that imposes, or may impose in our sole discretion an unreasonable or disproportionately large load on our infrastructure; or (b) interfere or attempt to interfere with the proper working of the Site or any activities conducted on the Site or other measures we may use to prevent or restrict access to the Site. </p>
<p><strong>6. License to Use Submissions</strong></p>
<p>All comments, articles, tutorials, screenshots, pictures, graphics, tools, downloads, and all other materials submitted to QR Marks the Spot in connection with the Site or available through the Site (collectively, "Submissions") remain the property and copyright of the original author. If You submit Submissions to our website, You must adhere to any applicable submission guidelines that may be posted from time to time on the Site. By submitting any Submission to our website, You grant QR Marks the Spot a worldwide, non-exclusive, transferable, perpetual, irrevocable, fully-paid royalty-free license and right to use, reproduce, distribute, import, broadcast, transmit, modify and create derivative works of, license, offer to sell, and sell, rent, lease or lend copies of, publicly display and publicly perform that Submission for any purpose and without restriction or obligation to You. </p>
<p>The foregoing license rights are intended to provide to QR Marks the Spot all rights under existing and future laws, including without limitation all rights under copyright and any other rights personal to You to publish the Submission on the Site, use the Submission in publicity and promotional materials for the Site and to create new Sites or derivative works (including without limitation by combining the Submission with other content) for public display or performance via any and all media or technology now known or later developed. The foregoing rights may be licensed and sublicensed through unlimited tiers of third parties. </p>
<p><strong>7. Claims of Copyright Infringement</strong></p>
<p>QR Marks the Spot respects the intellectual property rights of others, and QR Marks the Spot asks that all users of the Site do the same. If You believe that Your work has been published on the Site in a way that constitutes copyright infringement, You may notify QR Marks the Spot's copyright agent by providing the following information: </p>
<p> (a) Identification of the copyrighted work that You claim has been infringed. </p>
<p> (b) Identification of the material that You claim is infringing and needs to be removed, including a description of where it is located on the Site. </p>
<p> (c) Your address, telephone number, and, if available, e-mail address, so that QR Marks the Spot can contact You about Your complaint. </p>
<p> (d) And a signed statement that the above information is accurate; that You have a good faith belief that the identified use of the material is not authorized by the copyright owner, its agent, or the law; and, under penalty of perjury, that You are the copyright owner or are authorized to act on the copyright owner's behalf in this situation. </p>
<p>Notices of copyright infringement claims should be sent by E-Mail as follows:
By E-Mail:
wx08@software.nju.edu.cn</p>
<p>If You give QR Marks the Spot notice of copyright infringement by e-mail or phone, QR Marks the Spot's copyright agent may begin investigating the alleged copyright infringement; however, QR Marks the Spot's copyright agent must receive Your signature by mail or fax before QR Marks the Spot is required by law to take any action. More information about Chinese copyright law can be found at the Chinese Copyright Office. </p>
<p><strong>8. Logo Usage</strong></p>
<p>The QR Marks the Spot and QR Marks the Spot logos are propriety to QR Marks the Spot, and we retains all right, title, and interest in and to those logos. You agree that Your use, if any, of the QR Maker SPOT and marking logos will be used only in non-commercial usage.And you should contact us for commercial usage. </p>
<p><strong>9. Indemnity</strong></p>
<p>You agree to indemnify and hold QR Marks the Spot, its officers, employees, agents and volunteer administrators harmless against any and all losses, claims, damages, and expenses (including reasonable attorneys' fees) that QR Marks the Spot may incur in connection with: (a) Your breach of any of the terms of this Agreement; or (b) Your use of the Site. </p>
<p><strong>10. NO WARRANTIES</strong></p>
<p>Neither QR Marks the Spot, nor any successor, predecessor, agent, officer, or employee of QR Marks the Spot, warrants the accuracy, reliability, or timeliness of any information or downloads published to or otherwise accessible via the Site ("Site Information"). QR Marks the Spot will not be liable for any damage or loss caused by Your reliance on the accuracy, reliability, or timeliness of Site Information. Because of the number of possible sources of information available through the Site, and the inherent hazards and uncertainties of electronic distribution, there may be delays, omissions, or inaccuracies in the Site Information. The Site Information may include facts, views, opinions, and recommendations of individuals and organizations. QR Marks the Spot does not endorse, assert, or guarantee the truthfulness or reliability of any such facts, views, opinions, or recommendations, nor any statements made by persons other than authorized QR Marks the Spot spokespersons, including, without limitation, information contained in the forum areas of the Site. The Site may also contain links to one or more internet sites outside of the Site. QR Marks the Spot is not responsible for the content of such outside internet sites and does not warrant the accuracy, reliability, or timeliness of any information or downloads posted on or obtained from such outside internet sites. You rely on the Site Information, as well as information found on outside internet sites linked to the Site, at Your own risk. </p>
<p>Hiking, backpacking, and other outdoor activities involve risk to both persons and property. There are many variables including, but not limited to, weather, fitness level, terrain features and outdoor experience, that must be considered prior to seeking or placing a cache. Be prepared for Your journey and be sure to check the current weather and conditions before heading outdoors. Always exercise common sense and caution. You assume all risks arising in connection with seeking a cache or any other related activity. </p>
<p>THE SITE, INCLUDING WITHOUT LIMITATION THE SITE INFORMATION AND ALL OTHER CONTENT PROVIDED ON THE SITE, ARE PROVIDED TO YOU "AS IS", AND YOU ASSUME THE ENTIRE RISK AS TO YOUR USE OF THE SITE, THE SITE INFORMATION AND THE RESULTS AND PERFORMANCE OF THE SITE. QR Marks the Spot HEREBY DISCLAIMS ALL WARRANTIES, DUTIES OR CONDITIONS (IF ANY), WHETHER EXPRESS OR IMPLIED, WITH REGARD TO THE SITE OR ANY CONTENT PROVIDED ON THE SITE, INCLUDING BUT NOT LIMITED TO IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, WORKMANLIKE EFFORT, AND LACK OF NEGLIGENCE. GROUNDSPEAK GIVES NO WARRANTY AGAINST INTERFERENCE WITH YOUR ENJOYMENT OF THE SITE, AGAINST INFRINGEMENT, OR AS TO TITLE, OR THAT INFORMATION PROVIDED ON THE SITE, THE SITE ITSELF, OR GROUNDSPEAK'S EFFORTS, WILL FULFILL ANY OF YOUR PARTICULAR PURPOSES OR NEEDS. FURTHERMORE, GROUNDSPEAK GIVES NO WARRANTIES AS TO THE AVAILABILITY OF THE SITE AT ANY PARTICULAR TIME; FUNCTIONALITY; TIMELINESS OF SERVICES; ACCURACY OR CURRENCY OF CONTENT; LACK OF VIRUSES; OR ANY OTHER WARRANTY. </p>
<p><strong>11. LIMITATION OF DAMAGES</strong></p>
<p>TO THE FULLEST EXTENT PERMITTED BY LAW, AND REGARDLESS OF THE FORM OR CAUSE OF ACTION OR THE ALLEGED BASIS OF THE CLAIM, YOU AGREE THAT QR MARK SPOT, ITS OFFICERS, EMPLOYEES, AGENTS, AND VOLUNTEER ADMINISTRATORS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, CONSEQUENTIAL, PUNITIVE, SPECIAL, DIRECT, OR OTHER DAMAGES WHATSOEVER ARISING OUT OF OR RELATING TO THIS AGREEMENT OR YOUR USE OF THE SITE OR THE SITE INFORMATION, EVEN IF THEY HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES, AND EVEN IF THE REMEDIES OTHERWISE PROVIDED UNDER THIS AGREEMENT, AT LAW, OR IN EQUITY, FAIL OF THEIR ESSENTIAL PURPOSE. THIS LIMITATION AND EXCLUSION OF DAMAGES INCLUDES BUT IS NOT LIMITED TO DAMAGES FOR LOSS OF PROFITS OR CONFIDENTIAL OR OTHER INFORMATION, FOR BUSINESS INTERRUPTION, FOR PERSONAL INJURY, FOR LOSS OF PRIVACY, FOR FAILURE TO MEET ANY DUTY INCLUDING OF GOOD FAITH OR OF REASONABLE CARE, FOR NEGLIGENCE OR NEGLIGENT MISREPRESENTATION, AND FOR ANY OTHER PECUNIARY OR OTHER LOSS WHATSOEVER, EVEN IN THE EVENT OF THE FAULT OF GROUNDSPEAK, OF TORT (INCLUDING NEGLIGENCE), STRICT OR PRODUCT LIABILITY, BREACH OF CONTRACT, OR BREACH OF WARRANTY. </p>
<p>SHOULD A COURT OF COMPETENT JURISDICTION DETERMINE THAT THE LIMITATION ABOVE IS NOT LEGALLY VALID, ITS OFFICERS, EMPLOYEES, AGENTS AND VOLUNTEER ADMINISTRATOR'S LIABILITY FOR ANY CLAIMS ARISING OUT OF OR RELATING TO THIS AGREEMENT (INCLUDING ANY TERMS AND CONDITIONS REFERENCED IN THIS AGREEMENT) INCLUDING FOR ANY DIRECT DAMAGES ARISING FROM YOUR RELIANCE ON SITE INFORMATION, WILL BE LIMITED TO U.S.$10.00 OR THE AMOUNT OF DIRECT DAMAGES INCURRED BY YOU IN RELIANCE ON THIS SITE OR ON SITE INFORMATION, WHICHEVER IS LESS. YOU AGREE THAT THIS IS YOUR SOLE AND EXCLUSIVE REMEDY AND YOU HEREBY RELEASE GROUNDSPEAK, ITS OFFICERS, EMPLOYEES, AGENTS AND VOLUNTEER ADMINISTRATORS FROM ALL OBLIGATIONS, LIABILITY, CLAIMS OR DEMANDS IN EXCESS OF THE LIMITATION. </p>
<p><strong>12.About the android System</strong></p>
<p>We provide a client of system based on android System. You can down it freely and play with your friends. But you can’t decompile it or use it in business areas. We will inform you of the new version. And we don’t take on the lost it causes in your phone. You shall read our instructions and use it carefully. </p>
<p><strong>13. Attorney's Fees</strong></p>
<p>In any formal action or suit to enforce any right or remedy under this Agreement or to interpret any provision of this Agreement,we will be entitled to recover its costs, including reasonable attorneys' fees. </p>
<p><strong>14. Changes to this Agreement</strong></p>
<p>QR Marks the Spot reserves the right to revise the terms of this Agreement at any time and from time to time. Each time You use the Site, You are bound by the version of this Agreement that is in effect and posted on the Site at the time of Your use. Please review them. </p>
<p><strong>15. Severability; No Waiver; Entire Agreement. </strong></p>
<p>If any provision of this Agreement is found by a court of competent jurisdiction to be invalid or unenforceable, the parties agree that the remaining provisions of the Agreement will remain in full force and effect, and the allocation of risk described herein will be given effect to the fullest extent possible. QR Marks the Spot 's failure to act with respect to a breach by You or others does not constitute a waiver of QR Marks the Spot's right to enforce its rights with respect to subsequent or similar breaches. This Agreement, along with any Site guidelines or policies posted on the Site or otherwise provided to You by QR Marks the Spot, constitutes the entire agreement between You and QR Marks the Spot with regard to Your use of the Site. </p>


</div>

<br />
				
<s:checkbox name="agree" id="agree" value="false"/>
I Have Read and Agree to the Terms of the Use and Privacy Statement

<p>
<s:submit cssClass="mysubmitstyle" value="Sign Up!"></s:submit>
</p>

</s:form>

</body>
</html>