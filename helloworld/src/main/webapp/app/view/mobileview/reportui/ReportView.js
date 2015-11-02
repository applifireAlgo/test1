Ext.define('Helloworld.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Helloworld.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Helloworld.view.mobileview.reportui.datachart.DataChartViewTab',
			'Helloworld.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Helloworld.view.mobileview.reportui.ReportViewController' ,
			'Helloworld.view.mobileview.fw.DataPointPanel',
			'Helloworld.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
