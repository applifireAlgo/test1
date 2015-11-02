Ext.define('Helloworld.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Helloworld.view.art.masterform.MasterFormModel','Helloworld.view.art.masterform.MasterFormViewModel','Helloworld.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	