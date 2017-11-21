<%
	String charToolRoot      = (String)session.getServletContext().getAttribute("toolRoot");
%>
	<link id="bs-css" href="<%=charToolRoot%>/charisma-master/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="<%=charToolRoot%>/charisma-master/css/bootstrap-responsive.css"  type="text/css"  rel="stylesheet">
	<link href="<%=charToolRoot%>/charisma-master/css/charisma-app.css" rel="stylesheet">
	<link href="<%=charToolRoot%>/charisma-master/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='<%=charToolRoot%>/charisma-master/css/fullcalendar.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='<%=charToolRoot%>/charisma-master/css/chosen.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/uniform.default.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/colorbox.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/jquery.noty.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/noty_theme_default.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/elfinder.min.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/elfinder.theme.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/opa-icons.css' rel='stylesheet'>
	<link href='<%=charToolRoot%>/charisma-master/css/uploadify.css' rel='stylesheet'>
	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="<%=charToolRoot%>/charisma-master/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='<%=charToolRoot%>/charisma-master/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=charToolRoot%>/charisma-master/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="<%=charToolRoot%>/charisma-master/js/excanvas.js"></script>
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.flot.min.js"></script>
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.flot.pie.min.js"></script>
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.flot.stack.js"></script>
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=charToolRoot%>/charisma-master/js/jquery.history.js"></script>
	<script src="<%=charToolRoot%>/charisma-master/js/charisma.js"></script>
	