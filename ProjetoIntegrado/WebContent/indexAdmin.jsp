<%@include file="/Includes/HeaderAdmin.jsp" %>
<title>Area Administrador</title>
</head>
<link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.css'>
	<body class="fonte">
	<%@include file="/Includes/navBarAdmin.jsp" %>
<script>
  window.console = window.console || function(t) {};
</script>
<script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage("resize", "*");
  }
</script>
</head>
<br>
<br>
<br>
<br>
<body translate="no">
<div class="ui container">
</div>
<br />
<div class="ui container">
<div class="ui grid">
<div class="ui sixteen column">
<div id="calendar"></div>
</div>
</div>
</div>
<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js'></script>
<script type="text/javascript" charset="utf-8"  src="Includes/fullcalendar.min.js"></script>
<script id="rendered-js">
      $(document).ready(function () {

  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,basicWeek,basicDay' },

    defaultDate: '2016-12-12',
    navLinks: true, // can click day/week names to navigate views
    editable: true,
    eventLimit: true, // allow "more" link when too many events
    events: [
    {
      title: 'All Day Event',
      start: '2016-12-01' },

    {
      title: 'Long Event',
      start: '2016-12-07',
      end: '2016-12-10' },

    {
      id: 999,
      title: 'Repeating Event',
      start: '2016-12-09T16:00:00' },

    {
      id: 999,
      title: 'Repeating Event',
      start: '2016-12-16T16:00:00' },

    {
      title: 'Conference',
      start: '2016-12-11',
      end: '2016-12-13' },

    {
      title: 'Meeting',
      start: '2016-12-12T10:30:00',
      end: '2016-12-12T12:30:00' },

    {
      title: 'Lunch',
      start: '2016-12-12T12:00:00' },

    {
      title: 'Meeting',
      start: '2016-12-12T14:30:00' },

    {
      title: 'Happy Hour',
      start: '2016-12-12T17:30:00' },

    {
      title: 'Dinner',
      start: '2016-12-12T20:00:00' },

    {
      title: 'Birthday Party',
      start: '2016-12-13T07:00:00' },

    {
      title: 'Click for Google',
      url: 'https://google.com/',
      start: '2016-12-28' }] });




});
      //# sourceURL=pen.js
    </script>
<script src="https://static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script>
	<%@include file="/Includes/FooterAdmin.jsp" %>
	</body>
</html>