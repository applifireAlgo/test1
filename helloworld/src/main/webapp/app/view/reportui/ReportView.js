Ext.define('Helloworld.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Helloworld.view.reportui.querycriteria.QueryCriteriaView',
			'Helloworld.view.reportui.datachart.DataChartViewTab',
			'Helloworld.view.reportui.datachart.DataChartViewPanel',
			'Helloworld.view.reportui.ReportViewController' ,
			'Helloworld.view.fw.MainDataPointPanel',
			'Helloworld.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
