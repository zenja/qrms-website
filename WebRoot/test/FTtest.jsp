<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

  <html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>QRMS</title>
  </head>
  <body>
    <h1>QRMS</h1>

<!-- facebook sharebutton -->
	<div>
	<fb:share-button class="url" type="icon_link" href=<%=request.getRequestURL()%>></fb:share-button>
	</div>
	
	<br/>
	<br/>
	
	
	<!-- facebook comments should be together with the js under fb-root -->
    <div  style="overflow:auto;height:100%;">
     <fb:comments xid="Game_comments" title="Comments on the Game" canpost="true" candelete="true" reverse="true" >
     </fb:comments>
    </div>

	<br/>
	<br/>


<!-- retwit buttons  -->
	<div style='float:right; padding: 10px 10px 10px 10px'>
	<script type="text/javascript">
	tweetcount_url = '<data:post.url/>';
	tweetcount_title = '<data:post.title/>';
	//tweetcount_src = 'RT @supertony_zhao';
	tweetcount_via = false;
	tweetcount_links = true;
	tweetcount_size = 'small';
	tweetcount_background = 'FFFFFF';
	tweetcount_border = 'CCCCCC';
	tweetcount_api_key = '5c3bba3f5d77a46a13453091e36dc1cde4335e9299a1edeeaa3c31d193b33fda';
	</script> 
	<script type="text/javascript" src="http://widgets.backtype.com/tweetcount.js"></script>
	</div>

	<div>
 	<script type="text/javascript" src="http://tweetmeme.com/i/scripts/button.js"></script>
	</div>

	<br/>
	<br/>
	
	<div>
	<script type="text/javascript">
	tweetmeme_style = 'compact';
	</script>
	<script type="text/javascript" src="http://tweetmeme.com/i/scripts/button.js"></script>
	</div>

    
	
    <div id="fb-root"></div>
    <script>
      window.fbAsyncInit = function() {
        FB.init({appId: '148230755190920', status: true, cookie: true,
                 xfbml: true});
      };
      (function() {
        var e = document.createElement('script');
        e.type = 'text/javascript';
        e.src = document.location.protocol +
          '//connect.facebook.net/zh_CN/all.js';
        e.async = true;
        document.getElementById('fb-root').appendChild(e);
      }());
    </script>

 
    
    
    
    
    <!-- discus comment system -->
    
  	<div id="disqus_thread"></div>
	<script type="text/javascript">
  	/**
	    * var disqus_identifier; [Optional but recommended: Define a unique identifier (e.g. post id or slug) for this thread] 
	    */
	var disqus_developer = 1;
  	(function() {
   	var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
   	dsq.src = 'http://qrms.disqus.com/embed.js';
   	(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
  	})();
	</script>
	<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript=qrms#disqus_thread">comments powered by Disqus.</a></noscript>
	<a href="http://disqus.com" class="dsq-brlink">blog comments powered by <span class="logo-disqus">Disqus</span></a>
 
   
    <script type="text/javascript">
	var disqus_shortname = 'qrms';
    (function () {
  	var s = document.createElement('script'); s.async = true;
  	s.src = 'http://disqus.com/forums/qrms/count.js';
  	(document.getElementsByTagName('HEAD')[0] || document.getElementsByTagName('BODY')[0]).appendChild(s);
	}());
	</script>
    
    
       
    
   </body>
</html>