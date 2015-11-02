Ext.define('Helloworld.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Helloworld.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Helloworld.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
