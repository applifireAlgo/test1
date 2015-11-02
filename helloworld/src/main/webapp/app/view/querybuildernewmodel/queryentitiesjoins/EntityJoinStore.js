Ext.define('Helloworld.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Helloworld.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Helloworld.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
