Ext.define('Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Helloworld.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
