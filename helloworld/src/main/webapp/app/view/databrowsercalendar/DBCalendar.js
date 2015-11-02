Ext.define('Helloworld.view.databrowsercalendar.DBCalendar', {
	extend : 'Helloworld.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Helloworld.view.databrowsercalendar.DBCalendarController',
	             'Helloworld.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
