Ext.define('Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
